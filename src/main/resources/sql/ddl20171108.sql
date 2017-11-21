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

CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag_name` varchar(32) NOT NULL COMMENT '标签名',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  `priority` int(8) NOT NULL DEFAULT '0',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='标签表';

alter table problem add visit_count BIGINT DEFAULT 0 COMMENT '浏览数';
alter table problem add agree_count BIGINT DEFAULT 0 COMMENT '点赞数';
alter table problem add pro_status varchar(100) default 'w_handle' comment '状态: w_handle-待处理,p_handle-处理中,handled-已处理';
alter table problem add pro_point BIGINT DEFAULT 0 COMMENT '问题积分数';
