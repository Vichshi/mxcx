-- 合同信息表
CREATE TABLE `t_contract_info` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_number` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '合同号',
  `title` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '合同主题',
  `customer_info` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '客户信息公司名称',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '客户联系电话',
  `sign_date` datetime NOT NULL COMMENT '签订日期',
  `remark` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单合同表';

-- 订单信息表
CREATE TABLE `t_order_info` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_number` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '合同号',
  `order_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `product_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '产品名称',
  `product_color` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '产品颜色',
  `total_number` int(20) DEFAULT NULL COMMENT '总订单量',
  `unprocess_number` int(20) DEFAULT NULL COMMENT '未处理数量',
  `unit_price` decimal(5,2) DEFAULT NULL COMMENT '单价',
  `amount` decimal(9,2) DEFAULT NULL COMMENT '总金额',
  `un_settle_amount` decimal(9,2) DEFAULT NULL COMMENT '未结清金额',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单信息表';

-- 日志表
CREATE TABLE `t_record__info` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_number` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '合同号',
  `content` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '当次操作日志内容',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='记录日志信息表，记录每次出货详情';