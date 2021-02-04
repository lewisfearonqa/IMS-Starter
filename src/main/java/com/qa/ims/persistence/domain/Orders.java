package com.qa.ims.persistence.domain;

public class Orders {
	private Long id;
	private Long newitemID;
	

	public Orders(Long id, Long newitemID) {
		this.setId(id);
		this.setnewitemID(newitemID);
		
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
	
	@Override
	public String toString() {
		return "id:" + id + " item_id:" + newitemID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newitemID == null) ? 0 : newitemID.hashCode());
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
			if (other.newitemID != null)
				return false;
		} else if (!newitemID.equals(other.newitemID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return false;

	}

}

