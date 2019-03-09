package com.orange.sh.quartz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulerState {
	private String schedName;
	private String instanceName;
	private String lastCheckinTime;
	private String checkinInterval;
}
