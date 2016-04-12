CREATE DATABASE IF NOT EXISTS addressbook;

DROP TABLE IF EXISTS `addressbook`.`person`;
CREATE TABLE `addressbook`.`person` (
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `patronimic` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NULL,
  `email` VARCHAR(15) NULL,
  `birthday` DATE NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `addressbook`.`address`;
CREATE TABLE `addressbook`.`address` (
  `id` INT(11) AUTO_INCREMENT,
  `person_id` INT(11) NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `region` VARCHAR(30) NOT NULL,
  `street` VARCHAR(30) NULL,
  `house` VARCHAR(5) NULL,
  `flat` VARCHAR(5) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (uid) REFERENCES person(id))
  ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

INSERT INTO `addressbook`.`person` (`name`, `surname`, `patronimic`, `phone`, `email`, `birthday`) VALUES ('Doldrom', 'Moltenmane', 'Firetoe', '3894257', 'doldrom@wk.com', '1958-12-01');
INSERT INTO `addressbook`.`person` (`name`, `surname`, `patronimic`, `phone`, `email`, `birthday`) VALUES ('Bhelurus', 'Barleydust', 'Mountainbranch', '348534878', 'bhelurus@wk.com', '1971-02-21');

INSERT INTO `addressbook`.`address` (`uid`, `city`, `region`, `street`, `house`, `flat`) VALUES ('1', 'Gergran', 'Coldmane', 'Belihrdonore', '1', '2a');
INSERT INTO `addressbook`.`address` (`uid`, `city`, `region`, `street`, `house`, `flat`) VALUES ('2', 'Grungurn', 'Thunderbrand', 'Sternsteel', '7b', '20');
