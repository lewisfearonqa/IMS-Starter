
INSERT INTO `items` (`item_name`, price) VALUES ('tennis racket', 40);
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO orders(customer_id) VALUES (1);
INSERT INTO ordereditems(order_id, item_id) VALUES (1, 1);
DELETE FROM ordereditems WHERE order_id =1 and item_id =1;