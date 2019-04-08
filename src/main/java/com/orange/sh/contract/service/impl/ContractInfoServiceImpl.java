package com.orange.sh.contract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.orange.sh.config.exception.BussinessException;
import com.orange.sh.contract.dto.response.ContractInfoResp;
import com.orange.sh.contract.mapper.ContractInfoMapper;
import com.orange.sh.contract.model.ContractInfo;
import com.orange.sh.contract.service.ContractInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContractInfoServiceImpl implements ContractInfoService {
	
	@Autowired
	private ContractInfoMapper ContractInfoMapper;
	
	@Override
	public void save(ContractInfo contractInfo) {
		log.info("新增合同信息 ---->>>>> {}",JSON.toJSONString(contractInfo));
		ContractInfoMapper.insertContractInfo(contractInfo);
		
	}

	@Override
	public ContractInfoResp queryContractInfoDetails(String contractNumber) {
		log.info("合同号：contractNumber = {}",contractNumber);
		ContractInfoResp resp = ContractInfoMapper.queryContractInfoDetails(contractNumber);
		log.info("查询结果， ==>> {}",JSON.toJSONString(resp));
		return resp;
	}

	@Override
	public void updateContractInfo(ContractInfo info) {
		log.info("根据合同号更新基本信息,参数 -> {}",JSON.toJSONString(info));
		if(0 == ContractInfoMapper.updateByNumber(info)) {
			throw new BussinessException(1001,"合同基本信息修改失败");
		}

	}
	
}
