package com.orange.sh.quartz.service.impl;

import com.github.pagehelper.Page;
import com.orange.sh.quartz.entity.JobAndTrigger;
import com.orange.sh.quartz.service.JobAndTriggerService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobAndTriggerServiceImpl implements JobAndTriggerService{@Override
	public Page<JobAndTrigger> getJobAndTriggerDetails(Page<JobAndTrigger> page) {
		log.info("分页查询");
		return null;
	}

}
