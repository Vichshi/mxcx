package com.orange.sh.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class SystemLog {
	
	@Pointcut("@annotation(com.orange.sh.common.annotation.SystemLog)")
    public void controllerLog() {}
	
	@Before("controllerLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
 
        log.info("请求IP：{}", request.getRemoteAddr());
        log.info("请求路径：{}", request.getRequestURL());
        log.info("请求方式：{}", request.getMethod());
        log.info("方法描述：{}", getMethodDescription(joinPoint));
        log.info("请求参数：{}", JSONObject.toJSONString(request.getParameterMap()));
 
    }
	
	 /**
     * Print the time that request method execution spend
     * @param joinPoint
     * @throws Throwable
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object retVal = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        log.info("执行时间：{} ms", endTime - startTime);
        log.info("返回值：{}\n\t", JSONObject.toJSONString(retVal));
        return retVal;
    }
 
    /**
     * Print exception
     * @param ex
     */
    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void afterThrowing(Throwable ex) {
        log.error("发生异常：{}", ex.toString());
    }
 
    /**
     * Acquire the description for annotation target method
     * @param joinPoint
     * @return
     * @throws Exception
     */
    protected String getMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
 
        String description = "";
        for (Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(com.orange.sh.common.annotation.SystemLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


}
