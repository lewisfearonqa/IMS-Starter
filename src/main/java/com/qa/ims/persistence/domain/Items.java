package com.qa.ims.persistence.domain;

public class Items {
	private Long item_ID;
	private String itemName;
	private Long itemPrice;

	public  Items(String item_name, Long itemPrice) {
		this.setitemName(item_name);
		this.setitemPrice(itemPrice);
	}

	public  Items(Long item_ID, String itemName, Long itemPrice) {
		this.setitem_ID(item_ID);
		this.setitemName(itemName);
		this.setitemPrice(itemPrice);
	}

	public Long getitem_ID() {
		return item_ID;
	}

	public void setitem_ID(Long item_ID) {
		this.item_ID = item_ID;
	}

	public String getitemName() {
		return itemName;
	}

	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getitemPrice() {
		return itemPrice;
	}

	public void setitemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "item_ID:" + item_ID + " itemName:" + itemName + " itemPrice:" + itemPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((item_ID == null) ? 0 : item_ID.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
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
		Items other = (Items) obj;
		if (getitemName() == null) {
			if (other.getitemName() != null)
				return false;
		} else if (!getitemName().equals(other.getitemName()))
			return false;
		if (item_ID == null) {
			if (other.item_ID != null)
				return false;
		} else if (!item_ID.equals(other.item_ID))
			return false;
		if (itemPrice == null) {
			if (other.itemPrice != null)
				return false;
		} else if (!itemPrice.equals(other.itemPrice))
			return false;
		return true;
	}

}

