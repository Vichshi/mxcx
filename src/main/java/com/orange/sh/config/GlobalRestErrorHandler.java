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

import com.orange.sh.common.CommonResult;
import com.orange.sh.config.exception.BussinessException;
import com.orange.sh.contract.type.ErrorCode;

/**
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalRestErrorHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult processValidationError(MethodArgumentNotValidException e) {
        return new CommonResult(ErrorCode.SERVER_ERROR);
    }


    @ResponseBody
    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult processInvalidTokenException(BussinessException e) {
        return new CommonResult(e.getErrorCode(),e.getMessage(),null);
    }

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CommonResult processAccessDeniedException(AccessDeniedException e) {
        return new CommonResult(ErrorCode.NOT_ACCESSIBLE);
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public CommonResult processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return new CommonResult(ErrorCode.METHOD_NOT_ALLOWED);
    }


}
