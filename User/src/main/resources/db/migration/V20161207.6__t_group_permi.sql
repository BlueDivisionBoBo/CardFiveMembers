CREATE TABLE `t_group_permi` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `pid` int(11) COLLATE utf8_bin DEFAULT NULL COMMENT '权限ID',
  `gid` int(11) COLLATE utf8_bin DEFAULT NULL COMMENT '角色组ID',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限关联表';
