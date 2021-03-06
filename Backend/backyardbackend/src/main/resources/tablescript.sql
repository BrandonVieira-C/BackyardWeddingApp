
-- DROP DATABASE IF EXISTS backyardwedding_db;
-- CREATE DATABASE backyardwedding_db;
-- USE backyardwedding_db;

CREATE TABLE customer (
  customer_email CHAR(50),
  first_name VARCHAR(25),
  last_name VARCHAR(25),
  dob DATE,
  city VARCHAR(25),
  CONSTRAINT pk_customer PRIMARY KEY (customer_email)
);

CREATE TABLE partner (
  partner_id INT AUTO_INCREMENT,
  first_name VARCHAR(25),
  last_name VARCHAR(25),
  dob DATE,
  email VARCHAR(100),
  city VARCHAR(25),
  CONSTRAINT pk_partner PRIMARY KEY (partner_id)
);

CREATE TABLE backyard (
  backyard_id INT auto_increment,
  backyard_name VARCHAR(25),
  square_footage INT,
  city VARCHAR(25),
  partner_id INT,
  description VARCHAR(100),
  backyard_image VARCHAR(200),
  CONSTRAINT pk_backyard PRIMARY KEY (backyard_id),
  CONSTRAINT fk_backyard_partner FOREIGN KEY (partner_id) REFERENCES partner(partner_id)
);

CREATE TABLE event(
  event_id INT AUTO_INCREMENT,
  customer_email CHAR(50),
  amount_paid INT,
  date_of_event DATE,
  backyard_id INT,
  CONSTRAINT pk_event PRIMARY KEY (event_id),
  CONSTRAINT fk_event_customer FOREIGN KEY (customer_email) REFERENCES customer(customer_email),
  CONSTRAINT fk_event_backyard FOREIGN KEY (backyard_id) REFERENCES backyard(backyard_id)
);
--@block
INSERT INTO customer (customer_email, first_name, last_name, dob, city) VALUES 
    ("nubbynub@gmail.com", "nubby", "nub", "2001-06-15", "Narnia"),
    ('brandonv@gmail.com', 'Brandon', 'Vivalacious', '1993-12-13', 'Toronto');
    
INSERT INTO partner(first_name, last_name, dob, email, city) VALUES 
    ("Julia", "bubbles", "1995-03-13", "juliabubbles@gmail.com", "Narnia"),
    ("Addi", "Gandhi", "2001,05-18", "addighandi@gmail.com", "Toronto");

INSERT INTO backyard(backyard_name, square_footage, city, partner_id, description) VALUES
    ("Narnia retreat", 20000, "city of Aslan", 1, "a beautiful lawn with grass"),
    ("Toronto rockies", 15000, "city of Whitby", 2, "wit battle with the crows");

INSERT INTO event (customer_email, amount_paid, date_of_event, backyard_id) VALUES 
    ("nubbynub@gmail.com", 1050, "2022-09-25", 1),
    ("brandonv@gmail.com", 2030, "2022-11-24", 2);


