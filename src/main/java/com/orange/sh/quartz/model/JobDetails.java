package com.orange.sh.quartz.model;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDetails {

	private String schedName;
	private String jobName;
	private String jobGroup;
	private String description;
	private String jobClassName;
	private String isDurable;
	private String isNonconcurrent;
	private String isUpdateData;
	private String requestsRecovery;
	private Blob jobData;
	
}
