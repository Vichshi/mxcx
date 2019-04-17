package com.orange.sh.contract.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.sh.config.exception.BussinessException;
import com.orange.sh.contract.dto.response.ContractInfoResp;
import com.orange.sh.contract.dto.response.PageBeanDto;
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

	@Override
	public PageInfo<ContractInfo> queryRecords(int pageNum, int pageSize) {
		log.info("分页查询信息，当前页：{} ，每页条数：{}",pageNum,pageSize);
		/*List<List<ContractInfo>> result = new ArrayList<>();
		PageBeanDto<ContractInfo> page = new PageBeanDto<>();
		while(pageNum == 1 || page.getPages() >= page.getCurrent()) {
			pageNum = page.getCurrent();
			PageHelper.startPage(pageNum, pageSize);
			List<ContractInfo> list1 = ContractInfoMapper.selectRecords();
			result.add(list1);
			page.setCurrent(pageNum +1);
		}
		log.info("result -> {} ##### {}",result.size(),JSON.toJSONString(result));*/
		PageHelper.startPage(pageNum, pageSize);
		List<ContractInfo> list = ContractInfoMapper.selectRecords();
		return new PageInfo<ContractInfo>(list);
		
	}

	@Override
	public void delContractByNumber(String number) {
		// TODO Auto-generated method stub
		
	}
	
}
