CREATE TABLE `t_recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `money` decimal(10,2)  NOT NULL COMMENT '金额',
  `diamond` int(11) NOT NULL COMMENT '钻石数量',
  `present_diamond` int(11) NOT NULL COMMENT '赠送钻石数量',
  `type` int(2) NOT NULL DEFAULT '1' COMMENT '类型 0:基础类型 1:特殊类型',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `modify_user` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='充值规则表';


