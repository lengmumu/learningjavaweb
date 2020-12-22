#使用数据库
use test;

#创建管理员用户表
CREATE TABLE IF NOT EXISTS `ar_managers`(
	id int(11) primary key auto_increment,
	musername varchar(30) unique,
	mpassword varchar(30)
)default charset=utf8;

#创建用户表
CREATE TABLE IF NOT EXISTS `ar_users`(
	id int(11) primary key auto_increment,
	username varchar(30) unique,
	password varchar(30)
)default charset=utf8;

#创建用户信息表
CREATE TABLE IF NOT EXISTS `users_info`(
	id int(11) primary key,
	name varchar(20),
	sex enum('男','女','保密') default '保密' not null,
	birthday date,
	city varchar(50),
	saying varchar(50),
	foreign key(`id`) references ar_users(`id`) on delete cascade on update cascade
)default charset=utf8;

#创建同学录数据表,邀请码为邀请者的用户id，如果邀请者与被邀请者都做了删除处理，则该条数据做删除处理
create table if not exists `alumni_records`(
	id int(11) primary key auto_increment,
	user_id int(11) not null,
	delete_flag int(3) default 2,
	invited_code int(11) not null,
	image varchar(30),
	name varchar(20) not null,
	sex enum('男','女','保密')default '保密' not null,
	birthday date,
	mobile varchar(11),
	email varchar(30),
	address varchar(50),
	interests varchar(50),
	yearning_city varchar(15),
	image_to_inviter varchar(50),
	leave_message varchar(100),
	foreign key(invited_code) references ar_users(id),
	foreign key(user_id) references ar_users(id)
)default charset=utf8;
