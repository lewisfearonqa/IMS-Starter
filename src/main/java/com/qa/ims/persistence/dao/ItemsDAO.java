package com.qa.ims.persistence.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;


public  class ItemsDAO implements Dao<Items> {

	public static final Logger LOGGER = LogManager.getLogger();
    
	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_ID = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		Long itemPrice = resultSet.getLong("price");
		return new Items(item_ID, itemName, itemPrice);
	
		
	}
	
	
	@Override
	public List<Items> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Items readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Items read(Long item_ID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?");) {
			statement.setLong(1, item_ID);
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
	public Items create(Items Items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(item_name, price) VALUES (?, ?)");) {
			statement.setString(1, Items.getitemName());
			statement.setLong(2, Items.getitemPrice());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Items update(Items Items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE items SET item_name = ?, price = ? WHERE item_id = ?");) {
			statement.setString(1, Items.getitemName());
			statement.setLong(2, Items.getitemPrice());
			statement.setLong(3, Items.getitem_ID());
			statement.executeUpdate();
			return read(Items.getitem_ID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return null;
	}
	@Override
	public int delete(long item_ID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?");) {
			statement.setLong(1, item_ID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		
	}
	
	}
	


















	
