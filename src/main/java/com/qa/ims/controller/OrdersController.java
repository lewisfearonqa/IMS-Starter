package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;
	
	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}
	@Override
	public List<Orders> readAll() {
		List<Orders> order = ordersDAO.readAll();
		for (Orders orders : order) {
			LOGGER.info(orders);
		}
		return order;
	}
	@Override
	public Orders create() {
		LOGGER.info("Please enter your customer ID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the item ID of the item you'd like to order");
		Long itemID = utils.getLong();
		Orders orders = ordersDAO.create(new Orders(customerID, itemID));
		LOGGER.info("Thank you order created");
		return orders;
	}
		
	@Override
	public Orders update() {
			LOGGER.info("Please enter the id of the order you'd like to change");
			Long id = utils.getLong();
			LOGGER.info("Please enter the id of the new item you'd like to order");
			Long itemID = utils.getLong();
			LOGGER.info("Thank you your order has been updated");
			Orders orders = ordersDAO.update(new Orders(id, itemID));
			LOGGER.info("Customer Updated");
			return orders;
		
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you'd like to delete");
		Long id = utils.getLong();
		LOGGER.info("Your order has been deleted");
		return ordersDAO.delete(id);
	
	}

	


}


