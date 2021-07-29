set foreign_key_checks = 0;

truncate table incident;

insert into incident (id, name, description,created_at,update_at,closed_at,active) values (1, 'name1',"acidente de transito",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (2, 'name1',"acidente de transito2",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (3, 'name1',"acidente de transito3",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (4, 'name1',"acidente de transito4",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (5, 'name1',"acidente de transito5",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (6, 'name1',"acidente de transito6",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (7, 'name1',"acidente de transito7",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (8, 'name1',"acidente de transito8",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (9, 'name1',"acidente de transito9",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (10, 'name1',"acidente de transito10",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (11, 'name1',"acidente de transito11",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (12, 'name1',"acidente de transito12",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (13, 'name1',"acidente de transito13",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (14, 'name1',"acidente de transito14",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (15, 'name1',"acidente de transito15",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (16, 'name1',"acidente de transito16",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (17, 'name1',"acidente de transito17",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (18, 'name1',"acidente de transito18",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (19, 'name1',"acidente de transito19",utc_timestamp,null,null,"ativo");
insert into incident (id, name, description,created_at,update_at,closed_at,active) values (20, 'name1',"acidente de transito20",utc_timestamp,null,null,"ativo");

set foreign_key_checks = 1;

alter table incident auto_increment = 1;