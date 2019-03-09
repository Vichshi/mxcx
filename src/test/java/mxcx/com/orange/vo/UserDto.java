package mxcx.com.orange.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{

	//private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private Boolean del;
}
