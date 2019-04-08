package com.orange.sh.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.sh.common.CommonResult;
import com.orange.sh.contract.dto.response.DemoDto;
import com.orange.sh.contract.service.OrderInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contract-info")
@Slf4j
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
	@Value("${url}")
	private String url;
	@GetMapping("/test/{token}")
	public CommonResult<DemoDto> test(@PathVariable("token") String token){
		log.warn("加载文件内容：url -> {}",url);
		log.warn("token内容：token -> {}",token);
		DemoDto data = new DemoDto();
		data.setUsername("vich");
		data.setPassword(token+"%+");
		return CommonResult.success(data);
	}
}
