drop table if exists test_sql;
CREATE TABLE `test_sql` (
`id` bigint(20) unsigned NOT NULL COMMENT '测试表id',
`user_name` varchar(100) DEFAULT '' COMMENT 'user_name',
`user_age` int(2) DEFAULT null COMMENT 'user_age',
`user_birthday` datetime DEFAULT null COMMENT 'user_birthday',
`delete_info` int(2) DEFAULT 0 COMMENT '0未删除，1已删除',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`backup1` varchar(100) DEFAULT '' COMMENT '备用字段1',
`backup2` varchar(100) DEFAULT '' COMMENT '备用字段2',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '测试表';
create index test_sql_index ON test_sql(create_time,user_name,user_age,user_birthday);
