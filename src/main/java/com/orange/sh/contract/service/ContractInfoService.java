package com.orange.sh.contract.service;

import com.orange.sh.contract.dto.response.ContractInfoResp;
import com.orange.sh.contract.model.ContractInfo;

public interface ContractInfoService {
	
	void save(ContractInfo contractInfo);
	
	ContractInfoResp queryContractInfoDetails(String contractNumber);

	/**
	 * 更新合同基本信息
	 * @param info
	 */
	void updateContractInfo(ContractInfo info);
	
}
