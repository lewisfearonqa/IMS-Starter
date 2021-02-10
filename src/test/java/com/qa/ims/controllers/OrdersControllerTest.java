package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class OrdersControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrdersDAO dao;

	@InjectMocks
	private OrdersController controller;

	@Test
	public void testCreate() {
		final Long customerID = 1L;
		final Orders created = new Orders(customerID);

		Mockito.when(utils.getLong()).thenReturn(customerID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		final Long orderID = 1L;
		final Long itemID = 1L;
		final Orders addItemToOrder = new Orders(orderID, itemID);
		final Orders removeItemOrder = new Orders(orderID, itemID);

		Mockito.when(this.utils.getLong()).thenReturn(1L, addItemToOrder.getOrderID());
		Mockito.when(this.dao.update(addItemToOrder)).thenReturn(addItemToOrder);

		assertEquals(addItemToOrder, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(addItemToOrder);

		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(dao.update(removeItemOrder)).thenReturn(removeItemOrder);

		assertEquals(1L, this.controller.update());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).update(removeItemOrder);

	}

	@Test
	public void testDelete() {
		final long orderID = 1L;

		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(dao.delete(orderID)).thenReturn((int) 1L);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(orderID);
	}

}


