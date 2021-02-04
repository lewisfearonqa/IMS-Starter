package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long newitemID = resultSet.getLong("newitemid");
		return new Orders(id, newitemID);
	}
 
	
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(id) VALUES (?)");) {
			statement.setLong(1, orders.getnewitemID());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer read(Long newitemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, newitemID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	@Override
	public Customer update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE customers SET order_id = ? WHERE id = ?");) {
			statement.setLong(1, orders.getnewitemID());
			statement.setLong(3, orders.getId());
			statement.executeUpdate();
			return read(orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


	

}
