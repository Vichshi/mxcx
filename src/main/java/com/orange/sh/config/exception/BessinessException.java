package com.orange.sh.config.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BessinessException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	private String errorMessage;
	
	public BessinessException(int errorCode,String errorMessage) {
		super("错误代码：[" + errorCode + "] 错误信息："+errorMessage);
		this.setErrorCode(errorCode);
		this.setErrorMessage(errorMessage);;
	}

	public BessinessException(int errorCode) {
		super(String.valueOf(errorCode));
		this.errorCode = errorCode;
	}

	public BessinessException(int errorCode, String errorMessage,Throwable throwable) {
		super("错误代码：[" + errorCode + "] 错误信息："+errorMessage,throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	

}
