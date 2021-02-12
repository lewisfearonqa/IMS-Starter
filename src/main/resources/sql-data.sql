INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('lewis', 'fearon');
INSERT INTO `ims`.`orders` (`customer_id`) VALUES (1);
INSERT INTO `ims`.`orders` (`customer_id`) VALUES (2);
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES (`ball`, 10);
INSERT INTO `ims`.`ordereditems` (`order_id`, `item_id`) VALUES (1, 1);