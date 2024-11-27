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

INSERT INTO card (owner_name, owner_surname, account_id, card_number, total_limit, available_amount, created_at, created_by)
VALUES ('John', 'Doe', 1, '1234567890123456', 10000, 10000, '2022-01-01', 'John');

INSERT INTO card (owner_name, owner_surname, account_id, card_number, total_limit, available_amount, created_at, created_by)
VALUES ('Jakub', 'Kowalski', 2, '3334567890123456', 10000, 10000, '2022-01-01', 'Jakub');

INSERT INTO card (owner_name, owner_surname, account_id, card_number, total_limit, available_amount, created_at, created_by)
VALUES ('Kacper', 'Szczepanowski', 3, '5534567890123456', 10000, 10000, '2022-01-01', 'Kacper');