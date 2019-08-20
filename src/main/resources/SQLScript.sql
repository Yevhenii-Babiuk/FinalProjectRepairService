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
PRIMARY KEY (user_id));

CREATE TABLE IF NOT EXISTS `Order` (
id INT NOT NULL auto_increment,
client INT NOT NULL,
master INT ,
manager INT,
device INT NOT NULL,
comment LONGTEXT NOT NULL,
problem INT NULL,
start_date DATE NOT NULL,
status ENUM('created','accepted','done') NOT NULL DEFAULT 'created',
end_date DATE,
feedback INT,
PRIMARY KEY (id)); 


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


CREATE TABLE IF NOT EXISTS Problem (
id INT NOT NULL auto_increment,
problem TEXT NOT NULL,
price FLOAT,
PRIMARY KEY (id));

ALTER TABLE `Order`
ADD CONSTRAINT client_constraint
FOREIGN KEY (client)
REFERENCES User (id);

ALTER TABLE `Order`
ADD CONSTRAINT master_constraint
FOREIGN KEY (master)
REFERENCES Employees (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT manager_constraint
FOREIGN KEY (manager)
REFERENCES Employees (user_id);

ALTER TABLE `Order`
ADD CONSTRAINT device_constraint
FOREIGN KEY (device)
REFERENCES Device (id);

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
REFERENCES User (id);

ALTER TABLE Employees
ADD CONSTRAINT user_to_employyes
FOREIGN KEY (user_id)
REFERENCES User (id);


INSERT INTO `user` VALUES (1,'Yevhenii','Babiuk','Kyiv, Nizhinska street 29D','+380984468917','evgeniy0199@gmail.com','123456789','admin'),
(2,'Anton','Makovetskii','Kyiv, Nizhinska street 29D','+380991234567','maka_ska@gmail.com','987654321','master'),
(3,'Vitalii','Chmoryk','Kyiv, Nizhinska street 29D','+380639876543','vitalia_ch@gmail.com','147852369','master'),
(4,'Mykola','Antypenko','Kyiv, Nizhinska street 29D','+3809991478523','mykolaantypenko@gmail.com','963258741','master'),
(5,'Yevheniya','Zakasovska','Obolon, Marshala Tymoshenka 2z','+380980071305','zhenia_zakasovska@gmail.com','45512487','manager'),
(6,'Iryna','Beznosyuk','Kiyv, Nizhinska street 29D','+380981135258','irka_beznosyuk@gmail.com','88888888','manager'),
(7,'Igor','Kalnitsky','Mosow',' 79432145698','igor_kal@yandex.ru','789456123','client'),
(8,'Maks','Hevko','Kiyv, Nizhinska street 29D','+380981135258','maks_hevko@ukr.net','852123','client'),
(9,'Yurii','Bilay','Kiyv','+380981135333','az_best@ukr.net','852787819','client'),
(10,'Євген','Романов','Київ','+380984468998','evgen@gmail.com','123456789','client'),
(11,'Тетяна','Антипенко','Київ','+380980000333', 'tat_ant@gmail.com','789456123','client'),
(12,'Андрей','Токовой','Москва','+794384555698','andrew@ukr.net','55454656','client'),
(13,'Роман','Мінський','Мінськ','+380980000305','minsk@gmail.com','789456123','client'),
(14,'Мартин','Буруля','Закарпаття','+380738524562','martyn_bur@gmail.com','78746546','client');


INSERT INTO `problem` VALUES (1,'New screen',900),
(2,'Cleaning fingerprint',100),
(3, 'Reinstall OS', 150),
(4, 'Change processor', 2000),
(5, 'New display', 1500),
(6, 'Replacement HDD', 1700),
(7, 'Install SSD', 2200),
(8, 'Install extra RAM', 1100),
(9, 'Reistall speaker', 700),
(10, 'Replacement touchpad', 850),
(11, 'Cleaning fan', 220),
(12, 'Replacement motherboard', 3000),
(13, 'Replace disck driver', 750),
(14, 'Replacement USB', 200),
(15, 'Replacement camera module', 2300),
(16, 'Replacement button', 120);


INSERT INTO `device` VALUES (1,7,'Xiami Redmi','Note 4','123456789987'),
(2,8,'Lenovo ThinkPad','G570','147852369874'),
(3,9,'Meizu','M6 Note','124873469978'),
(4,10,'Xiaomi','Mi9','548126FGHJK454'),
(5,11,'iPhone', 'X', '5455844YUI8184'),
(6,12,'Samsung', 'S10', '52487564RTYVBN'),
(7,13,'Asus','Rog','965844POIQNB'),
(8,14,'HP','ProBook 455','8526654WERTVB'),
(9,7,'Dell','8455','34567890SDFGHJ'),
(10,8,'Huawei','P30','987650OKMNHGG');


INSERT INTO `employees` VALUES (1,'2018-06-14'),
(2,'2018-06-15'),
(3,'2018-06-17'),
(4,'2019-08-17'),
(5,'2018-06-17'),
(6,'2019-08-19');

INSERT INTO `feedback` VALUES (1,5,'Good service. I recomend it!'),
(2,5,'Good job!!!'),
(3,4,'Service can be faster'),
(4,5, 'Amazing service, my device as new as'),
(5,5, 'I will recomend it service my friends'),
(6,5, 'Perfect!');

INSERT INTO `order` VALUES (1,7,4,5,1,'Broken screen',1,'2018-12-04','done','2019-08-23',1),
(2,8,2,6,2,'Finger print doesn`t work',2,'2019-07-10','done','2019-07-29',2),
(3,9,3,6,3,'Infinity load',3,'2019-08-01','done','2019-08-17',3),
(4,10,3,6,4,'USB doesn`t work',14,'2019-07-25','done','2019-08-06',4),
(5,11,4,5,5,'Broken my screen',1,'2019-06-30','done','2019-07-30',5),
(6,12,2,6,6,'Lost power button',16,'2019-08-01','done','2019-08-17',6),
(7,13,4,5,7,'I want faster load of application',7,'2019-08-17','accepted','2019-08-30',NULL),
(8,14,3,5,8,'My notebook is very hot',10,'2019-08-18','accepted','2019-09-01',NULL),
(9,7,NULL,NULL,9,'Broken screen',NULL,'2019-08-19','created',NULL,NULL),
(10,8,NULL,NULL,10,'Broken screen',NULL,'2019-08-19','created',NULL,NULL);

CREATE USER service IDENTIFIED BY 'p@s$w0rD';

GRANT ALL PRIVILEGES ON repair_service.* TO service;

FLUSH PRIVILEGES;