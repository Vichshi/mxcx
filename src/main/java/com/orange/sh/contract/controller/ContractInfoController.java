package com.orange.sh.contract.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.orange.sh.common.CommonResult;
import com.orange.sh.common.annotation.SystemLog;
import com.orange.sh.contract.dto.response.ContractInfoResp;
import com.orange.sh.contract.model.ContractInfo;
import com.orange.sh.contract.service.ContractInfoService;
import com.orange.sh.contract.utils.AESUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "合同信息服务")
@RestController
@RequestMapping("/api/contract-info")
@SuppressWarnings(value = "rawtypes")
public class ContractInfoController {

	@Autowired
	private ContractInfoService contractInfoService;

	@ApiOperation(value = "新增合同记录", notes = "新增一条合同记录")
	@PostMapping
	@SystemLog(description = "新增合同记录")
	public CommonResult createContractInfo(@RequestBody ContractInfo info) {
		contractInfoService.save(info);
		return CommonResult.success();
	}

	@SystemLog(description = "查询合同订单详情")
	@ApiOperation(value = "查询合同订单详情", notes = "根据合同单号")
	@GetMapping("/{number}")
	@ApiImplicitParam(value = "number", paramType = "path", required = true, dataType = "string")
	public CommonResult<ContractInfoResp> queryDetails(@PathVariable("number") String number) {
		ContractInfoResp resp = contractInfoService.queryContractInfoDetails(number);
		return CommonResult.success(resp);
	}

	@ApiOperation(value = "更新合同基本信息", notes = "根据合同id更新")
	@PutMapping
	@SystemLog(description = "更新合同基本信息")
	public CommonResult updateContractInfo(@RequestBody ContractInfo info) {
		contractInfoService.updateContractInfo(info);
		return CommonResult.success();
	}

	@GetMapping("/records")
	public CommonResult<PageInfo> queryContractRecords(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
		PageInfo<ContractInfo> data = contractInfoService.queryRecords(pageNum,pageSize);
		return CommonResult.success(data);
	}
	
	@ApiOperation(value = "删除合同", notes = "根据合同号删除")
	@DeleteMapping("/{number}")
	@ApiImplicitParam(value = "number", paramType = "path", required = true, dataType = "string")
	public CommonResult deleteContractInfo(@PathVariable("number") String number) {
		contractInfoService.delContractByNumber(number);
		return null;
	}

	@ApiOperation(value = "数据加密")
	@SuppressWarnings("static-access")
	@PostMapping("/auth/encrypt")
	public CommonResult encryptData(@RequestBody Map<String, Object> params) {
		// Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String> data = this.encryptData1(params);
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
				value = valueObj.toString();// 用于请求参数中请求参数名唯一
			}
			returnMap.put(name, AESUtil.encrypt(value));
		}
		return returnMap;
	}

}
