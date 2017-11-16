create table problem(
	id BIGINT(20) not null auto_increment PRIMARY KEY COMMENT '问题流水号',
  member_id VARCHAR(32) not null COMMENT '会员编号',
	pro_title VARCHAR(500) not null COMMENT '问题标题',
  pro_type varchar(40)  not null COMMENT '问题类型',
  pro_degree varchar(40)  not null COMMENT '问题等级',
  pro_content LONGTEXT  DEFAULT null COMMENT '问题内容',
  create_time timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  modify_time timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表';

CREATE TABLE `usr_info` (
  `usr_id` varchar(64) DEFAULT NULL,
  `usr_name` varchar(300) DEFAULT NULL,
  `usr_pwd` varchar(300) DEFAULT NULL,
  `usr_phone` varchar(300) DEFAULT NULL,
  `usr_email` varchar(300) DEFAULT NULL,
  `usr_type` varchar(8) DEFAULT NULL,
  `usr_status` varchar(8) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

alter table problem add source VARCHAR(40) DEFAULT 'native' COMMENT '问题来源';
alter table problem add tag_list VARCHAR(200) DEFAULT '' COMMENT '标签集,以逗号分割';