package com.orange.sh.contract.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OrderInfo {
	
	/**
	 * 主键id
	 */
    private Integer id;

    /**
     *  合同号
     */
    private String contractNumber;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品颜色
     */
    private String productColor;

    /**
     * 下单总数
     */
    private Integer totalNumber;

    /**
     * 未出货数量
     */
    private Integer unprocessNumber;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     *  总金额
     */
    private BigDecimal amount;

    /**
     * 未结金额
     */
    private BigDecimal unSettleAmount;

    /**
     *  创建日期
     */
    private Date createDate;

    /**
     * 备注
     */
    private String remark;

 
}