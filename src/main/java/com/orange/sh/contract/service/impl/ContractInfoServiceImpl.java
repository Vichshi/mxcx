package com.orange.sh.contract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
	public void queryContractInfoDetails(String contractNumber) {
		log.info("合同号：contractNumber = {}",contractNumber);
		// TODO Auto-generated method stub
		ContractInfo contractInfoDetails = ContractInfoMapper.queryContractInfoDetails(contractNumber);
		log.info("查询结果， ==>> {}",JSON.toJSONString(contractInfoDetails));
	}
}
