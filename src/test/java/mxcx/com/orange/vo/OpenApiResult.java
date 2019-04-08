package mxcx.com.orange.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class OpenApiResult implements Serializable{

	private String ret;
	private String msg;
	private String data;
}
