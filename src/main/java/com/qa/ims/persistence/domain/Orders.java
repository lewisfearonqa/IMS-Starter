package com.qa.ims.persistence.domain;

public class Orders {
	private Long orderID;
	private Long customerID;
	private Long itemID;

	public Orders(Long orderID, Long itemID) {
		this.setorderID(orderID);
		this.setitemID(itemID);
		}
	public Long getorderID() {
		return orderID;
	}

	public void setorderID(Long orderID) {
		this.orderID= orderID;
	}

	public Long getitemID() {
		return itemID;
	}

	public void setitemID(Long itemID) {
		this.itemID = itemID;
	}
	
	@Override
	public String toString() {
		return "order_id:" + orderID + "item_Id:" + itemID;
	}
	public Orders(Long customerID) {
		this.setcustomerID(customerID);
		
	}
	public Long getcustomerID() {
		return customerID;
	}
	public void setcustomerID(Long customerID) {
		this.customerID=customerID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (orderID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return false;

	}

}

