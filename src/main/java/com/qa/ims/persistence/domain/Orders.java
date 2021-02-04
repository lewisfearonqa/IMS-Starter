package com.qa.ims.persistence.domain;

public class Orders {
	private Long id;
	private Long newitemID;
	private Long custid;

	public Orders(Long id, Long newitemID, Long custid) {
		this.setId(id);
		this.setnewitemID(newitemID);
		this.setcustid(custid);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getnewitemID() {
		return newitemID;
	}

	public void setnewitemID(Long newitemID) {
		this.newitemID = newitemID;
	}
	public Long getustid() {
		return custid;
		}
	public void setcustid(Long custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "id:" + id + " item_id:" + newitemID + "custid:" + custid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newitemID == null) ? 0 : newitemID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((custid == null) ? 0 : custid.hashCode());
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
			if (other.newitemID != null)
				return false;
		} else if (!newitemID.equals(other.newitemID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (custid == null) {
			if (other.custid != null)
				return false;
		} else if (!custid.equals(other.custid))
			return false;
		return false;

	}

}

