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

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemsController;
import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
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
			final Long customer_id = 1L;
			final Orders created = new Orders(customer_id);

			Mockito.when(utils.getLong()).thenReturn(customer_id);
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
			Orders updated = new Orders(1L, 1L);

			Mockito.when(this.utils.getLong()).thenReturn(1L);
			Mockito.when(this.utils.getLong()).thenReturn(1L);
			Mockito.when(this.dao.update(updated)).thenReturn(updated);

			assertEquals(updated, this.controller.update());

			Mockito.verify(this.utils, Mockito.times(1)).getLong();
			Mockito.verify(this.utils, Mockito.times(1)).getString();
			Mockito.verify(this.dao, Mockito.times(1)).update(updated);
		}
		@Test
		public void testAddItemToOrder() {
			final Long orderID = 1L;
			final Long itemID =  1L;
			final Orders created = new Orders(orderID, itemID);

			Mockito.when(utils.getLong()).thenReturn(orderID);
			Mockito.when(utils.getLong()).thenReturn(itemID);
			Mockito.when(dao.create(created)).thenReturn(created);

			assertEquals(created, controller.create());

			Mockito.verify(utils, Mockito.times(1)).getLong();
			Mockito.verify(utils, Mockito.times(1)).getLong();
			Mockito.verify(dao, Mockito.times(1)).create(created);
		}
		
		@Test
		public void testRemoveItemOrder() {
			final long itemID = 1L;

			Mockito.when(this.utils.getLong()).thenReturn(1L);
			Mockito.when(this.utils.getLong()).thenReturn(1L);
			Mockito.when(this.dao.delete(itemID)).thenReturn((int) 1L);

			assertEquals(1L, this.controller.delete());

			Mockito.verify(this.utils, Mockito.times(1)).getLong();
			Mockito.verify(this.utils, Mockito.times(1)).getLong();
			Mockito.verify(this.dao, Mockito.times(1)).delete(itemID);
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


