/*创建数据库*/
create database db_item;

/*使用库*/
use db_item;

/*创建用户表*/
create table t_sys_user(u_id int,u_name varchar(30),age int,other varchar(500));

/*插入一条数据*/
insert into t_sys_user(u_id,u_name,age,other)
values(123,'tom',1,'2017年6月4日好不容易弄个ibatis+springmvc');



