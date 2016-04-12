CREATE DATABASE IF NOT EXISTS addressbook;
USE addressbook;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `city` varchar(30) NOT NULL,
  `region` varchar(30) NOT NULL,
  `street` varchar(30) DEFAULT NULL,
  `house` varchar(5) DEFAULT NULL,
  `flat` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_person` (`person_id`),
  CONSTRAINT `FK_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

ALTER TABLE `address` DISABLE KEYS;
INSERT INTO `address` VALUES (51,50,'Gergran','Coldmane','Belihrdonore','1','2a'),(52,51,'Grungurn','Thunderbrand','Sternsteel','7b','20');
ALTER TABLE `address` ENABLE KEYS;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `patronimic` varchar(30) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

ALTER TABLE `person` DISABLE KEYS;
INSERT INTO `person` VALUES (50,'Doldrom','Moltenmane','Firetoe','3894257','doldrom@wk.com','1958-12-01'),(51,'Bhelurus','Barleydust','Mountainbranch','348534878','bhelurus@wk.com','1971-02-21');
ALTER TABLE `person` ENABLE KEYS;