CREATE TABLE `t_staff_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `pp` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码保护码',
  `phone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '电话号码',
  `account` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '帐号',
  `password` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `level` int(2) NOT NULL COMMENT '角色: 1:超级管理员 2:代理管理员',
  `gid` int(2) NOT NULL COMMENT '所属权限组',
  `safety` int(2) NOT NULL COMMENT '安全设置开关 : 1:开 2:关',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `modify_user` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后台登陆账户表';

INSERT INTO `t_staff_user` VALUES (1, 'admin', NULL, '7892', '13554011992',
                                      'admin', '15ad818ae7c2f123afec0c4a391746c2', 1, 1, 1, '2016-12-9 00:05:37',
                                   NULL, '2016-12-9 00:05:21', '', '1');

