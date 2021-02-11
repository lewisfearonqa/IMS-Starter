package com.qa.ims.persistence.dao;


	

	import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
	import java.util.List;

	import org.junit.Before;
	import org.junit.Test;

	import com.qa.ims.persistence.domain.Customer;
	import com.qa.ims.utils.DBUtils;

	public class CustomerDAOFailTest {

		private final CustomerDAO DAO = new CustomerDAO();

		@Before
		public void setup() {
			DBUtils.connect("fail");
			DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		}

		@Test
		public void testCreate() {
			final Customer created = new Customer(2L, "chris", "perrins");
			assertNull(DAO.create(created));
		}

}
