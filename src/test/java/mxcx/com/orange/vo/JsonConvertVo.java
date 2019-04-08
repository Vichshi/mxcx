package mxcx.com.orange.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonConvertVo<T> implements Serializable{

	private String status;
	private String msg;
	private T data;
}
