package com.orange.sh.config;

import java.nio.file.AccessDeniedException;

import org.apache.commons.lang3.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.orange.sh.contract.dto.CommonResult;
import com.orange.sh.contract.type.ErrorCode;

/**
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class ExceptionTranslator {

//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public CommonResult processValidationError(MethodArgumentNotValidException e) {
//        return new CommonResult(ErrorCode.REQUEST_ERROR);
//    }
//
//
//    @ResponseBody
//    @ExceptionHandler(CommonException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public CommonResult processInvalidTokenException(CommonException e) {
//        return new CommonResult(e.getErrorCode());
//    }
//
//    @ResponseBody
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public CommonResult processAccessDeniedException(AccessDeniedException e) {
//        return new CommonResult(ErrorCode.NOT_ACCESSIBLE);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public CommonResult processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//        return new CommonResult(ErrorCode.METHOD_NOT_ALLOWED);
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<CommonResult> processRuntimeException(Exception e) {
//        ResponseEntity.BodyBuilder builder;
//        CommonResult commonResult;
//        ResponseStatus responseStatus = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
//        if (responseStatus != null) {
//            builder = ResponseEntity.status(responseStatus.value());
//            commonResult = new CommonResult(responseStatus.value().value() + "", responseStatus.reason());
//        } else {
//            builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//            commonResult = new CommonResult(ErrorCode.INTERNAL_SERVER_ERROR);
//        }
//        return builder.body(commonResult);
//    }
}
