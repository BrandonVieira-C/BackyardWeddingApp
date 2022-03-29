
DROP DATABASE IF EXISTS backyardwedding_db;
CREATE DATABASE backyardwedding_db;
USE backyardwedding_db;

CREATE TABLE CUSTOMER (
  customer_email CHAR(50),
  first_name VARCHAR(25),
  last_name VARCHAR(25),
  dob DATE,
  city VARCHAR(25),
  CONSTRAINT pk_customer PRIMARY KEY (customer_email)
);
create table PARTNER (
  partner_id int AUTO_INCREMENT,
  first_name varchar(25),
  last_name varchar(25),
  dob date,
  email varchar(100),
  city varchar(25),
  PRIMARY KEY (partner_id)
);
create table BACKYARD (
  backyard_id int auto_increment,
  backyard_name varchar(25),
  square_footage int,
  city varchar(25),
  partner_id int,
  description varchar(100),
  backyard_image varchar(200),
  foreign key (partner_id) references PARTNER(partner_id),
  primary key (backyard_id)
);
CREATE TABLE EVENT(
  event_id INT AUTO_INCREMENT,
  customer_email CHAR(50),
  amount_paid INT,
  date_of_event DATE,
  backyard_id INT,
  CONSTRAINT pk_event PRIMARY KEY (event_id),
  CONSTRAINT fk_event_customer FOREIGN KEY (customer_email) REFERENCES CUSTOMER(customer_email),
  CONSTRAINT fk_event_backyard FOREIGN KEY (backyard_id) REFERENCES BACKYARD(backyard_id)
);
INSERT INTO CUSTOMER (customer_email, first_name, last_name, dob, city) VALUES 
    ("nubbynub@gmail.com","nubby","nub","2001-06-15","Narnia"),
    ('brandonv@gmail.com','Brandon','Vivalacious','1993-12-13','Toronto');

INSERT INTO PARTNER(first_name, last_name, dob, email, city) VALUES 
    ("Julia", "bubbles", "1995-03-13", "juliabubbles@gmail.com", "Kelowna"),
    ("Addi", "Gandhi", "2001,05-18", "addighandi@gmail.com", "Calgary");

INSERT INTO BACKYARD(backyard_name, square_footage, city, partner_id, description) VALUES
    ("india retreat", 20000, "mumbai", 1, "a beautiful lawn with grass"),
    ("vietnam rockies", 15000, "pho", 2, "underwater scubba with corals");

INSERT INTO EVENT (customer_email, amount_paid, date_of_event, backyard_id) VALUES 
    ("nubbynub@gmail.com", 1050, "2022-09-25", 1),
    ("brandonv@gmail.com", 2030, "2022-11-24", 2);


