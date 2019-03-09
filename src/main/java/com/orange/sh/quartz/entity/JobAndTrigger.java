package com.orange.sh.quartz.entity;

import java.math.BigInteger;

import lombok.Data;

@Data
public class JobAndTrigger {

	private String jobName;
	private String jobGroup;
	private String jobClassName;
	private String triggerName;
	private String triggerGroup;
	private String triggerState;
	private String triggerType;
	private BigInteger repeatInterval;
	private BigInteger timesTriggered;
	private String cronExpression;
	private String timeZoneId;
}
