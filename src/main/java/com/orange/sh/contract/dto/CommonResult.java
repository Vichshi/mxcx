package com.orange.sh.contract.dto;

import java.io.Serializable;

import com.orange.sh.contract.type.ErrorCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
     * 0000为返回正常， 其它code均为请求错误
     */
    private int code;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String message;

    public CommonResult() {
        this.code = 0;
        this.message = "";
    }

    public CommonResult(Object data) {
        this();
        this.data = data;
    }

    public CommonResult(String message) {
        this.code = 9999;
        this.message = message;
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
	
}
