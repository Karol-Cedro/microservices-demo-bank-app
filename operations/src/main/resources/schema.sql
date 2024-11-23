CREATE TABLE IF NOT EXISTS `operation` (
    `operation_id` int NOT NULL AUTO_INCREMENT,
    `operation_type` varchar(15) NOT NULL,
    `operation_amount` int NOT NULL,
    `account_id` int NOT NULL,
    PRIMARY KEY (`operation_id`)
    );