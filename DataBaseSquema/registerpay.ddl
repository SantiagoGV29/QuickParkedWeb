CREATE TABLE `registerpay` (
  `id` bigint NOT NULL,
  `price` double DEFAULT NULL,
  `vehicleplate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci