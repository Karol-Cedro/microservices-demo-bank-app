CREATE TABLE IF NOT EXISTS `account` (
    `account_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `surname` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `account_number` int NOT NULL,
    `balance` int NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`account_id`)
    );

INSERT INTO `account` (`name`,`surname`,`email`,`mobile_number`,`account_number`,`balance`,`created_at`,`created_by`)
    VALUES ('John', 'Doe', 'jondoe@example.com',654321567, 1234590126, 100000, '2022-01-01', 'John');

INSERT INTO `account` (`name`,`surname`,`email`,`mobile_number`,`account_number`,`balance`,`created_at`,`created_by`)
    VALUES ('Jakub', 'Kowalski', 'jakubkowalski@example.com',654421567, 1554577126, 100000, '2022-01-01', 'Jakub');

INSERT INTO `account` (`name`,`surname`,`email`,`mobile_number`,`account_number`,`balance`,`created_at`,`created_by`)
    VALUES ('Kacper', 'Szczepanowski', 'kacperszczepanowski@example.com',462387156, 934590126, 100000, '2022-01-01', 'Kacper');