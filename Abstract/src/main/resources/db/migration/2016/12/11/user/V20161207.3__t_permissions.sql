CREATE TABLE `t_permissions` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `url` varchar(100) NOT NULL COMMENT 'api路径',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `modify_user` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权 限';