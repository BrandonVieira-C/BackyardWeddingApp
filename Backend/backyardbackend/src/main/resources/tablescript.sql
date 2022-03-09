drop schema if exists backyardwedding_db;
create schema backyardwedding_db;
use backyardwedding_db;

create table Customer (
	customer_id int AUTO_INCREMENT,
	first_name varchar(25),
	last_name varchar(25),
	dob date,
	email varchar(100),
	city varchar(25),
	primary key (customer_id)
);

create table Partner (
	partner_id int AUTO_INCREMENT,
	first_name varchar(25),
	last_name varchar(25),
	dob date,
	email varchar(100),
	city varchar(25),
	PRIMARY KEY (partner_id)
);

create table Event (
	event_id int auto_increment,
	customer_id int,
	amount_paid int,
	date_of_event date,
	partner_id int,
	foreign key (partner_id) references Partner(partner_id),
	foreign key (partner_id) references Customer(customer_id),
	primary key (event_id)
	
);

create table Backyard (
	backyard_id int auto_increment,
	backyard_name varchar(25),
	square_footage int,
	city varchar(25),
	partner_id int,
	description varchar(100),
	backyard_image varchar(200),
	foreign key (partner_id) references Partner(partner_id),
	primary key (backyard_id)
);

insert into Customer values (1, 'Brandon', 'Vieira', '1993-08-29', 'brandon.c.vieira@gmail.com', 'Whitby');
