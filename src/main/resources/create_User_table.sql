CREATE TABLE `User` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` int(3) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
