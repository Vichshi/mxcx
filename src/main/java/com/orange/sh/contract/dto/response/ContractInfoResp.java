package com.orange.sh.contract.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ContractInfoResp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 合同号
	 */
	private String contractNumber;
	
	/**
	 * 客户信息
	 */
	private String customerInfo;
	
	private String phone;
	
	private Date signDate;
	
	private String remark;

	/**
	 * 订单信息
	 */
	private List<OrderInfoResp> orderInfos;
}
