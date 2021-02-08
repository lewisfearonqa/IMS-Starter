drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `ims`.`orders`(
`order_id` INT(11) NOT NULL AUTO_INCREMENT,
`id` INT(11) NOT NULL,
PRIMARY KEY(`order_id`),
FOREIGN KEY(`id`) REFERENCES `customers`(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
`item_id` INT(50) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(100) NOT NULL,
price INT(50) NOT NULL,
PRIMARY KEY(`item_id`));

CREATE TABLE IF NOT EXISTS `ims`.`orderedit`(
`ordered_id` INT(50) NOT NULL AUTO_INCREMENT,
`order_id` INT,
`item_id` INT,
PRIMARY KEY(`ordered_id`),
FOREIGN KEY(`order_id`) REFERNCES `orders`(`order_id`),
FOREIGN KEY(`item_id`) REFERNCES `items`(`item_id`));
