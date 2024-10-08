create table category (id integer not null auto_increment, created_at datetime(6), updated_at datetime(6), name varchar(255), primary key (id)) engine=InnoDB;
create table product (category_id integer, id integer not null auto_increment, created_at datetime(6), updated_at datetime(6), description varchar(255), imageurl varchar(255), price varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id);
