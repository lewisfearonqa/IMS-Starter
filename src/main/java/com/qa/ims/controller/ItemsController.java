package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter the name of the item");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price of the item");
		Long itemPrice = utils.getLong();
		Items items = itemsDAO.create(new Items(itemName, itemPrice));
		LOGGER.info("Item added to database");
		return items;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item want to update");
		Long item_ID = utils.getLong();
		LOGGER.info("Please enter the new item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the new item price");
		Long itemPrice = utils.getLong();
		Items items = itemsDAO.update(new Items(item_ID, itemName, itemPrice));
		LOGGER.info("Item has been updated");
		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long item_ID = utils.getLong();
		return itemsDAO.delete(item_ID);
	}

}

