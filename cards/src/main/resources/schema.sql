CREATE TABLE IF NOT EXISTS `card` (
    `card_id` int NOT NULL AUTO_INCREMENT,
    `owner_name` varchar(15) NOT NULL,
    `owner_surname` varchar(15) NOT NULL,
    `account_id` int NOT NULL,
    `card_number` varchar(100) NOT NULL,
    `total_limit` int NOT NULL,
    `available_amount` int NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`card_id`)
    );