CREATE TABLE `t_sell` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `proxy_id` int(11)  NOT NULL COMMENT '代理人ID',
  `player_id` varchar(50) NOT NULL COMMENT '玩家ID',
  `game_currency_amount` varchar(50) NOT NULL COMMENT '玩家ID',
  `sell_date` datetime NOT NULL COMMENT '出售时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `is_enable` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='出售记录表';


