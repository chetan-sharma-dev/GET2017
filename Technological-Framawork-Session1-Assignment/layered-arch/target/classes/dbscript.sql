//create database get_testdb;
create database product_database;
CREATE USER 'chetan'@'localhost' IDENTIFIED BY 'chetanp';
GRANT ALL ON product_database.* TO 'chetan'@'localhost';

use product_database;

create TABLE User (
  id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(25),
  lastname VARCHAR(25),
  type VARCHAR(10),
  active BOOLEAN
);

create TABLE Product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25),
  price INT
);