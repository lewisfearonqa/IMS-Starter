package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOFailTest {

	private final OrdersDAO DAO = new OrdersDAO(new ItemsDAO());

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		List<Items> items = new ArrayList<>();
		final Orders created = new Orders(2L, 1L, items);
		assertNull(DAO.create(created));
	}

}
