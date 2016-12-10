CREATE TABLE `t_group_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `gid` int(11) COLLATE utf8_bin DEFAULT NULL COMMENT '角色租ID',
  `mid` int(11) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色组菜单 关联表';
