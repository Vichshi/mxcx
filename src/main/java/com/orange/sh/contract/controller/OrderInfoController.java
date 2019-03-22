package com.orange.sh.contract.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/test")
	public CommonResult<DemoDto> test(HttpServletRequest request){
		log.info(request.getParameter("content"));
		log.warn("加载文件内容：url -> {}",url);
		DemoDto data = new DemoDto();
		data.setUsername("vich");
		data.setPassword("123456");
		return CommonResult.success(data);
	}
}
