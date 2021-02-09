drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
`item_id` INT(50) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(100) NOT NULL,
`price` DOUBLE,
PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
`order_id` INT(11) NOT NULL AUTO_INCREMENT,
`customer_id` INT(50),
PRIMARY KEY (`order_id`),
FOREIGN KEY (`customer_id`) REFERENCES `customers`(`customer_id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `ims`.`ordereditems`(
`ordered_id` INT(50) NOT NULL AUTO_INCREMENT,
`order_id` INT NOT NULL,
`item_id` INT NOT NULL,
PRIMARY KEY (`ordered_id`),
FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`) ON DELETE CASCADE,
FOREIGN KEY (`item_id`) REFERENCES `items`(`item_id`) ON DELETE CASCADE
);
