CREATE DATABASE city_zip_code;

USE city_zip_code;

CREATE TABLE states(
state_id INT AUTO_INCREMENT UNIQUE,
state_name VARCHAR(30),
PRIMARY KEY(state_id)
);

CREATE TABLE cities(
city_id INT AUTO_INCREMENT UNIQUE,
zip_code INT(6) NOT NULL,
state_id INT,
city_name VARCHAR(30) NOT NULL,
PRIMARY KEY(zip_code),
CONSTRAINT cities_table_state_id_constraint FOREIGN KEY(state_id) REFERENCES states (state_id)
);



