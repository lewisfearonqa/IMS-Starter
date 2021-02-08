package com.qa.ims.persistence.domain;

public class Orders {
	private Long orderID;
	private Long customerID;
	private Long itemID;
	private String additem;

	

	public Orders(Long customerID) {
		this.setcustomerID(customerID);

	}
	public Orders(String additem, Long orderid, Long itemid) {
		this.setadditem(additem);
		this.setorderid(orderid);
		this.setitemid(itemid);
	}
	
	public Orders(Long orderID, Long customerID) {
		this.setorderID(orderID);
		this.setcustomerID(customerID);
		this.setorderID(itemID);
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
	public Long getitemID() {
		return itemID;
	}

	public void setitemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getadditem() {
		return additem;
	}

	public void setadditem(String additem) {
		this.additem = additem;
	}
	public Long getorderid() {
		return orderID;
	}

	public void setorderid(Long orderid) {
		this.orderID = orderid;
	}
	public Long getitemid() {
		return itemID;
	}

	public void setitemid(Long itemid) {
		this.itemID = itemid;
	}
	@Override
	public String toString() {
		return "order_id:" +  orderID  +" " +  "id:" + customerID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
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
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		return false;
	}
	
}
