package com.orange.sh.quartz.job.impl;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.orange.sh.quartz.job.BaseJob;

public class NewJob implements BaseJob{
	
	public NewJob() {
		super();
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("New Job开始执行时间: "+ new Date());
		
	}

}
