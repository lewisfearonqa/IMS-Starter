INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`item_name`, price) VALUES ('ball', 40);
INSERT INTO orders(customer_id) VALUES (1);
INSERT INTO ordereditems(order_id, item_id) VALUES (1, 1);
SELECT * FROM orders ORDER BY order_id DESC LIMIT 1;
DELETE FROM ordereditems WHERE order_id =1 and item_id =1;
INSERT INTO `items` (`item_name`, price) VALUES ('ball', 40);