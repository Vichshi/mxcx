package com.orange.sh.contract.service;

import com.orange.sh.contract.model.ContractInfo;

public interface ContractInfoService {
	
	void save(ContractInfo contractInfo);
	
	void queryContractInfoDetails(String contractNumber);
	
}
