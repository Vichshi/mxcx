package com.orange.sh.contract.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.orange.sh.contract.model.ContractInfo;

@Mapper
public interface ContractInfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

    ContractInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContractInfo record);

    int updateByPrimaryKey(ContractInfo record);
	
	int insertContractInfo(ContractInfo contractInfo);
	
	ContractInfo queryContractInfoDetails(@Param("contractNumber") String contractNumber);
}
