package com.orange.sh.contract.model;

import java.util.Date;

import lombok.Data;

@Data
public class ContractInfo {

	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 合同号
	 */
	private String contractNumber;
	
	/**
	 * 主题，合同名称
	 */
	private String title;
	
	/**
	 * 客户信息，公司名
	 */
	private String customerInfo;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 合同签订日期
	 */
	private Date signDate;
	
	/**
	 * 备注
	 */
	private String remark;
}
