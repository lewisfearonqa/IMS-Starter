package com.qa.ims.persistence.domain;

public class Orders {
	private Long orderID;
	private Long customerID;

	public Orders(Long customerID) {
		this.setcustomerID(customerID);

	}

	public Orders(Long orderID, Long customerID) {
		this.setorderID(orderID);
		this.setcustomerID(customerID);
	}

	public Long getorderID() {
		return orderID;
	}

	public void setorderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getcustomerID() {
		return customerID;
	}

	public void setcustomerID(Long customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "order_id: " + orderID + "id: " + customerID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());

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
		if (getorderID() == null) {
			if (other.getorderID() != null)
				return false;
		} else if (!getorderID().equals(other.getorderID()))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		return true;
	}

}
