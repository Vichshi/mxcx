package com.orange.sh.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.sh.contract.service.OrderInfoService;

@RestController
@RequestMapping("/contract-info")
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
}
