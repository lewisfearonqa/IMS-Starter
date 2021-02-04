package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(orders);
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter your customer id");
		Long custid = utils.getLong();
		Orders orders = ordersDAO.create(new Orders(custid));
		LOGGER.info("Order created");
		return orders;
	}

	@Override
	
	public Orders update() {
		LOGGER.info("Please enter your customer id");
		Long custid = utils.getLong();
		LOGGER.info("Please enter the order id of the order you'd like to change");
		Long id = utils.getLong();
		LOGGER.info("Please enter the item id that you'd like to add");
		Long newitemID = utils.getLong();
		Orders orders = ordersDAO.update(new Orders(id, newitemID, custid);
		LOGGER.info("Order Updated");
		return orders;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you wish to delete");
		Long id = utils.getLong();
		return ordersDAO.delete(id);
	}

}


