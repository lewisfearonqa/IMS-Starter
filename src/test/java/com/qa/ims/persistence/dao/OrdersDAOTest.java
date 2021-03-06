package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {

	private final OrdersDAO DAO = new OrdersDAO(new ItemsDAO());
	private Orders testOrders;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		List<Items> items = new ArrayList<>();
		final Orders created = new Orders(2L, 1L, items);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		List<Items> items = new ArrayList<>();
		expected.add(new Orders(1L, 1L, items));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		List<Items> items = new ArrayList<>();
		final Orders expected = new Orders(1L, 1L, items);
		assertEquals(expected, DAO.readLatest());
	}

	@Test
	public void testRead() {
		List<Items> items = new ArrayList<>();
		final long ID = 1L;
		final Orders order = new Orders(1L, 1L, items);
		assertEquals(order, DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		List<Items> items = new ArrayList<>();
		final Orders updated = new Orders(1L, 1L, items);
		assertNull(DAO.update(updated));
	}

	@Test
	public void testAddItemToOrder() {
		List<Items> items = new ArrayList<>();
		items.add(new Items(1L, "tennis racket", 40L));
		testOrders = new Orders(1L, 1L, items);
		assertEquals(testOrders, DAO.addItemToOrder(1L, 1L));

	}

	@Test
	public void testRemoveItemOrder() {
		List<Items> items = new ArrayList<>();
		items.clear();
		testOrders = new Orders(1L, 1L, items);
		assertEquals(testOrders, DAO.removeItemOrder(1L, 1L));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}


