CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片路径',
  `grade` int(3) NOT NULL DEFAULT '1' COMMENT '等级',
  `parentnode_id` int(3) DEFAULT NULL COMMENT '父节点ID',
  `type` int(2) NOT NULL DEFAULT '1' COMMENT '类型 1:菜单节点 2:功能按钮',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `modify_user` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单';