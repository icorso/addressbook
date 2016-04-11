
CREATE DATABASE IF NOT EXISTS addressbook;

USE addressbook;

CREATE TABLE `addressbook`.`person` (
  `id` INT AUTO_INCREMENT,
  `addr_id` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `patronimic` VARCHAR(30) NOT NULL,
  `phone` tinyint(10) NULL,
  PRIMARY KEY (`id`));
