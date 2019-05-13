package com.orange.sh.contract.service.impl;

import org.springframework.stereotype.Service;

import com.orange.sh.config.exception.BussinessException;
import com.orange.sh.contract.service.OrderInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService{@Override
	public void test() {
	log.info("发生异常");
		// TODO Auto-generated method stub
	throw new BussinessException(333, "异常传递");
	}

}
