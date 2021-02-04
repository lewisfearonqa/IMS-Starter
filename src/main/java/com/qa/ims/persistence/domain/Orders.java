package com.qa.ims.persistence.domain;

public class Orders {
	private Long id;
	private Long customerID;
	

	public Orders(Long id, Long customerID) {
		this.setId(id);
		this.setcustomerID(customerID);
		}
	public Orders(Long newitemID) {
		this.setcustomerID(newitemID);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getcustomerID() {
		return customerID;
	}

	public void setcustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " customerID" + customerID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());

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
		if (id == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return false;

	}

}

