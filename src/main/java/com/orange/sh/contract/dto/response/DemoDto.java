package com.orange.sh.contract.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoDto {
	
	private String username;
	private String password;

}
