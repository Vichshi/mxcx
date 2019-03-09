package com.orange.sh.quartz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CronTriggers {

	private String schedName;
	private String triggerName;
	private String triggerGroup;
	private String cronExpression;
	private String timeZoneId;
	
}
