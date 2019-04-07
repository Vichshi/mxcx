package com.orange.sh.contract.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="合同信息实体",description="合同信息详情描述")
@JsonInclude(value=Include.NON_EMPTY)
public class ContractInfo {

	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 合同号
	 */
	@ApiModelProperty(value="合同单号",dataType="string",example="YZY20190407102940333218",notes="YZY+日期+时间+三个随机数")
	private String contractNumber;
	
	/**
	 * 主题，合同名称
	 */
	@ApiModelProperty(value="合同名称",notes="合同主题，应包含客户公司名",example="金龙鱼合同")
	private String title;
	
	/**
	 * 客户信息，公司名
	 */
	@ApiModelProperty(value="客户信息",example="金龙鱼")
	private String customerInfo;
	
	/**
	 * 联系电话
	 */
	@ApiModelProperty(value="客户联系方式",example="15256984848")
	private String phone;
	
	/**
	 * 合同签订日期
	 */
	@ApiModelProperty(value="合同签订日期",example="2019-04-07")
	private Date signDate;
	
	/**
	 * 备注
	 */
	@ApiModelProperty(value="合同备注")
	private String remark;
}
