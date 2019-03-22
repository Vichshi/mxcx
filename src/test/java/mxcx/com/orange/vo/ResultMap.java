package mxcx.com.orange.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.orange.sh.common.CommonResult;

import lombok.Data;

@Data
@SuppressWarnings(value = {"unchecked","rawtypes"})
@JsonInclude(Include.NON_NULL)
public class ResultMap<T> {

	private int code;
	
	private String message;
	
	private T data;
}
