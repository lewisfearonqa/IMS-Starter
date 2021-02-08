package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public  class OrdersController implements CrudController<Orders> {

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
		Orders order = ordersDAO.create(new Orders(customerID));
		LOGGER.info("Order created");
		return order;
	}


	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long itemID = utils.getLong();
		Orders order = ordersDAO.update(new Orders(itemID));
		LOGGER.info("Order Updated");
		return order;
	}
	public Orders update1() {
		LOGGER.info("Would you like to add an item to your order? Yes or No ");
		String additem = utils.getString();
		LOGGER.info("Please enter your order ID");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the ID of the item you would like to order");
		Long itemid = utils.getLong();
		Orders update1 = ordersDAO.update(new Orders(additem, orderid, itemid));
		LOGGER.info("Order Updated");
		return update1;
	}
	public int update2() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemID = utils.getLong();
		return ordersDAO.delete(itemID);
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderID = utils.getLong();
		return ordersDAO.delete(orderID);
	}
}


