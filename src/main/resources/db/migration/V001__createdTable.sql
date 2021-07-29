create table incident(
	id bigint not null auto_increment,
	name varchar(60) not null,
	description text not null,
	created_at datetime not null,
	update_at datetime,
	closed_at datetime,
	active varchar(15),
	
	primary key (id)
) engine=InnoDB default charset=utf8;
