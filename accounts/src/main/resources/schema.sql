CREATE TABLE IF NOT EXISTS `account` (
    `account_id` int AUTO_INCREMENT  PRIMARY KEY,
    `account_number` int NOT NULL,
    `account_type` varchar(100) NOT NULL,
    `name` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
    );