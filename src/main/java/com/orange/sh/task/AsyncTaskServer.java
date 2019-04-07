package com.orange.sh.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orange.sh.task.thread.ThreadTask;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncTaskServer {
	
	private ExecutorService executorService;
	
	@Autowired
	private ThreadTask task;

	@PostConstruct
	private void initThread() {
		log.info("初始化线程池");
		executorService = Executors.newFixedThreadPool(4);
	}
	
	public void startTask() {
		executorService.execute(task);
	}
}
