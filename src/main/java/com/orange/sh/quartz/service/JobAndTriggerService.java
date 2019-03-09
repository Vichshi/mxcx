package com.orange.sh.quartz.service;

import com.github.pagehelper.Page;
import com.orange.sh.quartz.entity.JobAndTrigger;

public interface JobAndTriggerService {
	Page<JobAndTrigger> getJobAndTriggerDetails(Page<JobAndTrigger> page);
}
