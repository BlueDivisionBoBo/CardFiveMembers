CREATE TABLE `t_login_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `uid` int(11) NOT NULL  COMMENT '用户ID',
  `date` datetime COLLATE utf8_bin DEFAULT NULL COMMENT '时间',
  `address` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `source` int(2) COLLATE utf8_bin DEFAULT NULL COMMENT '来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='登录信息表';
