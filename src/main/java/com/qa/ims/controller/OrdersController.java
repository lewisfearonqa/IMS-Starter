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
		Orders order = ordersDAO.create(new Orders(customerID));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Orders update() {
		Orders orderUpdate = null;

		LOGGER.info("Please enter your order id");
		Long orderID = utils.getLong();
		LOGGER.info("Would you like to add an item to your order. Please enter Add or Delete");
		String addOrDelete = utils.getString();

		switch (addOrDelete) {
		case "Add":
			LOGGER.info("Please enter the id of the item you wish to add to your order");
			Long itemID = utils.getLong();
			orderUpdate = this.ordersDAO.addItemToOrder(orderID, itemID);
			LOGGER.info("The item has been added. Thank you");
			break;
		case "Delete":
			LOGGER.info("Please enter the item ID");
			Long itemId = utils.getLong();
			orderUpdate = this.ordersDAO.removeItemOrder(orderID, itemId);
			LOGGER.info("The item has been deleted and your order has been update");
			break;
		default:
			LOGGER.info("Use retrun to return to the main menu, Thank you ");
			break;
		}
		return orderUpdate;

		
		}
				

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderID = utils.getLong();
		return ordersDAO.delete(orderID);
	}
}
