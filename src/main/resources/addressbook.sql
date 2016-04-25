DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(30) NOT NULL,
  `region` varchar(30) NOT NULL,
  `street` varchar(30) DEFAULT NULL,
  `house` varchar(5) DEFAULT NULL,
  `flat` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_id` int(11) DEFAULT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `middle_name` varchar(30) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_fk` (`address_id`),
  CONSTRAINT `address_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `address` VALUES (1,'Gergran','Coldmane','Belihrdonore','1','2a'),(2,'Grungurn','Thunderbrand','Sternsteel','7b','20');
INSERT INTO `person` VALUES (1,1,'Doldrom','Moltenmane','Firetoe','3894257','doldrom@wk.com','1958-12-01'),
  (2,2,'Bhelurus','Barleydust','Mountainbranch','348534878','bhelurus@wk.com','1971-02-21'),
  (3,NULL,'Joyurt','Otr','Tercous','987684953','bhelurus@wk.com','1987-12-30');