package com.orange.sh.quartz.job.impl;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.orange.sh.quartz.job.BaseJob;

public class HelloJob implements BaseJob{
	

	public HelloJob() {
		super();
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello Job开始执行时间: "+ new Date());
	}

}
