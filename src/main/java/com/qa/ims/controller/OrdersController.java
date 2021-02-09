package com.qa.ims.controller;

import java.util.List;
import java.util.Scanner;

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
		Orders order = ordersDAO.create(new Orders(customerID));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderID = utils.getLong();
		try {
			do {
				switch(action) {
				case "Yes":
					LOGGER.info("Would you like to add an item to your order. Please enter Yes or No");
					break;
				case "No":
				LOGGER.info("Would you like to delete an item that you have within your order? Please enter Yes or No");
				break;
				case "Yes":
					LOGGER.info("Please enter your order ID");
					LOGGER.info("Please enter the item ID");
					LOGGER.info("The item has been deleted and your order has been update");
					break;
				default:
					LOGGER.info("Use retrun to return to the main menu, Thank you ");
					
			finally {
				
			}
		
//		LOGGER.info("Please enter the ID of the item you would like to add to your order");
//		Long itemID = utils.getLong();
//		Orders order = ordersDAO.update(new Orders(orderID, itemID));
//		LOGGER.info("Order Updated");
//		return order;
//			}}
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderID = utils.getLong();
		return ordersDAO.delete(orderID);
	}
}
