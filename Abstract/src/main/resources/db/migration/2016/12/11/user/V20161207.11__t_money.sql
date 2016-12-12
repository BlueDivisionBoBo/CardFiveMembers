CREATE TABLE `t_money` (
  id int(11) NOT NULL AUTO_INCREMENT ,
  uid int(11) NOT NULL  COMMENT '代理ID',
  remaining_sum INT(11) DEFAULT '0' COMMENT '余额',
  is_enable char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='代理余额表';

