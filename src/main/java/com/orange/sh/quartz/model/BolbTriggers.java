package com.orange.sh.quartz.model;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BolbTriggers {

	private String schedName;
	private String triggerName;
	private String triggerGroup;
	private Blob blobData;

}
