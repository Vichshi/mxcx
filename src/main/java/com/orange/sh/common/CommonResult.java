package com.orange.sh.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.orange.sh.contract.type.ErrorCode;

import lombok.Data;

@Data
@SuppressWarnings(value = {"unchecked","rawtypes"})
@JsonInclude(Include.NON_NULL)
public class CommonResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
     * 0000为返回正常， 其它code均为请求错误
     */
    protected int code;

    /**
     * 返回数据
     */
    protected T data;

    /**
     * 错误信息
     */
    protected String message;

	public static <T> CommonResult<T> success(){
    	return new CommonResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),(Object)null);
    }
    
    public static <T> CommonResult<T> success(String message){
    	return new CommonResult(ErrorCode.SUCCESS.getCode(),message,(Object)null);

    }
    
    public static <T> CommonResult<T> success(T data){
    	return new CommonResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),data);
    }
    
    public static <T> CommonResult<T> success(String message,T data){
    	return new CommonResult(ErrorCode.SUCCESS.getCode(),message,data);
    }
    
   
    public static <T> CommonResult<T> fail(){
    	return new CommonResult(ErrorCode.SERVER_ERROR.getCode(),ErrorCode.SERVER_ERROR.getMessage(),(Object)null);
    }
    
    public static <T> CommonResult<T> fail(String message){
    	return new CommonResult(ErrorCode.SERVER_ERROR.getCode(),message,(Object)null);

    }
    
    public static <T> CommonResult<T> fail(T data){
    	return new CommonResult(ErrorCode.SERVER_ERROR.getCode(),ErrorCode.SERVER_ERROR.getMessage(),data);
    }
    
    public static <T> CommonResult<T> fail(String message,T data){
    	return new CommonResult(ErrorCode.SERVER_ERROR.getCode(),message,data);
    }
    public static <T> CommonResult<T> fail(int code,String message,T data){
    	return new CommonResult(code,message,data);
    }

	public CommonResult(int code, String message, T data) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public CommonResult() {
		super();
	}
	
	public CommonResult(ErrorCode errorCode) {
		super();
		this.setCode(errorCode.getCode());
		this.setMessage(errorCode.getMessage());
	}
	
	

}
