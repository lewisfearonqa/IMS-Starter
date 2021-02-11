package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemDAOFailTest {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items(2L, "ball", 40L);
		assertNull(DAO.create(created));
	}
}
