package com.orange.sh.contract.dto.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Data;

@Data
public class PageBeanDto<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long total;
	
	private int size = 10;
	
	private long pages;
	
	private int current = 1;
	
	private List<T> records = Collections.emptyList();
}
