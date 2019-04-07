package com.orange.sh.contract.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.orange.sh.contract.dto.response.ContractInfoResp;
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
	
	ContractInfoResp queryContractInfoDetails(@Param("contractNumber") String contractNumber);

	/**
	 * 根据合同号更新基本信息
	 * @param info
	 */
	int updateByNumber(@Param("info") ContractInfo info);
}
