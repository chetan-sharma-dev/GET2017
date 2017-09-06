CREATE DATABASE category_database;

USE category_database;

CREATE TABLE category(
category_id INT AUTO_INCREMENT UNIQUE,
parent_category_name VARCHAR(30),
category_name VARCHAR(30),
PRIMARY KEY(category_name),
 FOREIGN KEY category_id_constraint(parent_category_name) REFERENCES category (category_name)
);
