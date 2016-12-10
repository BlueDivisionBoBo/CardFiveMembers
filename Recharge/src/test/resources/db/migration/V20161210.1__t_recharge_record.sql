CREATE TABLE `t_recharge_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  'satff_id' int(11) NOT NULL COMMENT '管理员ID',
  'proxy_id' int(11) NOT NULL COMMENT '代理员ID',
  'amount' DECIMAL(10,2) NOT NULL COMMENT '金额',
  'recharge_id' int(11) NOT NULL COMMENT '充值规则ID',
  'buy_diamond' int(11) NOT NULL COMMENT '购买钻石数量',
  'present_diamond' int(11) NOT NULL COMMENT '赠送钻石数量',
  'get_total_diamond' int(11) NOT NULL COMMENT '所得钻石总数量',
  'pay_way' int(2) NOT NULL COMMENT'0:现金支付',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='充值记录表';


