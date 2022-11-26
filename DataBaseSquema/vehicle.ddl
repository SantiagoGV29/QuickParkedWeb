CREATE TABLE `vehicle` (
  `id` bigint NOT NULL,
  `licenceplate` varchar(255) DEFAULT NULL,
  `slotparkingid` bigint DEFAULT NULL,
  `typevehicleid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl6dvnt7r4gga6rdf1tqn2m786` (`slotparkingid`),
  KEY `FKi82e1wr2ku4nb4jpe5ww0pwbp` (`typevehicleid`),
  CONSTRAINT `FKi82e1wr2ku4nb4jpe5ww0pwbp` FOREIGN KEY (`typevehicleid`) REFERENCES `typevehicle` (`id`),
  CONSTRAINT `FKl6dvnt7r4gga6rdf1tqn2m786` FOREIGN KEY (`slotparkingid`) REFERENCES `slotparking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci