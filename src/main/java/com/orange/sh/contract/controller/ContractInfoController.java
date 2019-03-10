package com.orange.sh.contract.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.sh.contract.model.ContractInfo;
import com.orange.sh.contract.service.ContractInfoService;

@RestController
@RequestMapping("/api/contract-info")
public class ContractInfoController {
	
	@Autowired
	private ContractInfoService contractInfoService;
	
	@PostMapping
	public Object createContractInfo(@RequestBody ContractInfo info) {
		contractInfoService.save(info);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("message", "success");
		return result;
	}
	
	@GetMapping("/{number}")
	public Object queryDetails(@PathVariable("number") String contractInfo) {
		contractInfoService.queryContractInfoDetails(contractInfo);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("message", "success");
		return result;
	}

}
