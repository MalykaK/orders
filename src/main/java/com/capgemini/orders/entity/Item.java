package com.capgemini.orders.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="itemstable")
public class Item {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
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
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}
	@Id
	private int itemId;
	private int itemQuantity;
	private int itemProductId;
	//private double itemTotal;
	public Item(int itemId, int itemQuantity, int itemProductId) {
		super();
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.itemProductId = itemProductId;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemProductId() {
		return itemProductId;
	}
	public void setItemProductId(int itemProductId) {
		this.itemProductId = itemProductId;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", itemProductId=" + itemProductId + "]";
	}
	
}
