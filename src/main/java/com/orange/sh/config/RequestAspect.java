package com.orange.sh.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RequestAspect {
	@Pointcut("execution(public * com.orange.sh.contract.controller..*.*(..))")
	public void log() {};

	@Before("log()")
	public void proxBefore(JoinPoint joinPoint) {
		List<Object> args = Arrays.asList(joinPoint.getArgs()).stream()
				.filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
				.collect(Collectors.toList());

		log.info("接收参数信息 -> {} . {} -参数:{}", joinPoint.getSignature().getDeclaringType().getSimpleName(),
				joinPoint.getSignature().getName(), JSON.toJSONString(args));
	}
	
	@After("log()")
	public void proxAfter(JoinPoint joinPoint) {
		log.info("{} . {} - 处理完毕", joinPoint.getSignature().getDeclaringType().getSimpleName(),
				joinPoint.getSignature().getName());
	}
	
	@AfterReturning(returning="result",pointcut="log()")
	public void proxAfterReturning(Object result) {
		log.info("返回：{}",JSON.toJSONString(result));
	}
}
