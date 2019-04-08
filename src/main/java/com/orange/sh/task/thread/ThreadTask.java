package com.orange.sh.task.thread;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ThreadTask implements Runnable{

	@Override
	public void run() {
		log.info("当前线程名，{}",Thread.currentThread().getName());
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
