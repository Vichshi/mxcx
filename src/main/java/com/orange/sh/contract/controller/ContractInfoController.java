package com.orange.sh.contract.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.sh.common.CommonResult;
import com.orange.sh.contract.dto.response.ContractInfoResp;
import com.orange.sh.contract.model.ContractInfo;
import com.orange.sh.contract.service.ContractInfoService;
import com.orange.sh.contract.utils.AESUtil;

@RestController
@RequestMapping("/api/contract-info")
public class ContractInfoController {
	
	@Autowired
	private ContractInfoService contractInfoService;
	
	@PostMapping
	public CommonResult createContractInfo(@RequestBody ContractInfo info) {
		contractInfoService.save(info);
		return CommonResult.success();
	}
	
	@GetMapping("/{number}")
	public CommonResult<ContractInfoResp> queryDetails(@PathVariable("number") String contractInfo) {
		ContractInfoResp resp = contractInfoService.queryContractInfoDetails(contractInfo);
		return CommonResult.success(resp);
	}
	
	@PostMapping("/auth/encrypt")
	public CommonResult encryptData(@RequestBody Map<String,Object> params) {
		//Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String,String> data = this.encryptData1(params);
		return new CommonResult().success(data);
		
	}

	private Map<String, String> encryptData1(Map<String, Object> parameterMap) {
		 Map<String, String> returnMap = new HashMap<String, String>();
		         Iterator<Entry<String, Object>> iter = parameterMap.entrySet().iterator();
		         String name = "";
		         String value = "";
		         while (iter.hasNext()) {
		             Entry<String, Object> entry = iter.next();
		             name = entry.getKey();
		             Object valueObj = entry.getValue();
		             if (null == valueObj) {
		                 value = "";
		             } else {
		                 value = valueObj.toString();//用于请求参数中请求参数名唯一
		             }
		             returnMap.put(name, AESUtil.encrypt(value));
		         }
		         return returnMap;
	}

}
