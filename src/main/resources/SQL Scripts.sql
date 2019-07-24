CREATE DATABASE IF NOT EXISTS repair_service DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

USE repair_service;

CREATE TABLE IF NOT EXISTS User(
id INT NOT NULL AUTO_INCREMENT,
name TEXT NOT NULL,
surname TEXT NOT NULL,
address TEXT NOT NULL,
phone TEXT NOT NULL,
login TEXT NOT NULL,
password TEXT NOT NULL,
role ENUM('admin','manager','master','client') NOT NULL DEFAULT 'client',
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Employees (
user_id INT NOT NULL,
start_date DATE NOT NULL,
experience INT NOT NULL DEFAULT 0,
PRIMARY KEY (user_id));

CREATE TABLE IF NOT EXISTS `Order` (
id INT NOT NULL auto_increment,
client INT NOT NULL,
manager INT NOT NULL,
master INT NOT NULL,
device INT NOT NULL,
problem INT NOT NULL,
start_date DATE NOT NULL,
status boolean DEFAULT FALSE,
end_date DATE,
feedback INT,
PRIMARY KEY (id)); 

CREATE TABLE IF NOT EXISTS Client (
user_id INT NOT NULL,
PRIMARY KEY (user_id));

CREATE TABLE IF NOT EXISTS Device(
id INT NOT NULL AUTO_INCREMENT,
client INT NOT NULL,
brand TEXT,
model TEXT,
imei TEXT,
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Feedback(
id INT NOT NULL auto_increment,
rate INT(1),
text LONGTEXT,
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Problem_type (
id INT NOT NULL auto_increment,
type TEXT NOT NULL,
price FLOAT,
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Problem (
id INT NOT NULL auto_increment,
problem TEXT NOT NULL,
problem_type INT,
PRIMARY KEY (id));

ALTER TABLE `Order`
ADD CONSTRAINT client_constraint
FOREIGN KEY (client)
REFERENCES Client (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT manager_constraint
FOREIGN KEY (manager)
REFERENCES Employees (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT master_constraint
FOREIGN KEY (master)
REFERENCES Employees (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT device_constraint
FOREIGN KEY (device)
REFERENCES Employees (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT problem_constraint
FOREIGN KEY (problem)
REFERENCES Problem (id);

ALTER TABLE `Order`
ADD CONSTRAINT feedback_constraint
FOREIGN KEY (feedback)
REFERENCES Feedback (id);

ALTER TABLE Device
ADD CONSTRAINT client_device
FOREIGN KEY (client)
REFERENCES Client (user_id);

ALTER TABLE Problem
ADD CONSTRAINT problem_type
FOREIGN KEY (problem_type)
REFERENCES Problem_type (id);

ALTER TABLE Employees
ADD CONSTRAINT user_to_employyes
FOREIGN KEY (user_id)
REFERENCES User (id);

ALTER TABLE Client
ADD CONSTRAINT user_to_client
FOREIGN KEY (user_id)
REFERENCES User (id);

CREATE USER service IDENTIFIED BY 'p@s$w0rD';

GRANT ALL PRIVILEGES ON repair_service.* TO service;

FLUSH PRIVILEGES;