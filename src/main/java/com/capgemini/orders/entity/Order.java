package com.capgemini.orders.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orderstable")
public class Order {
	
	@Id
	private int orderId;
	private double orderTotal;
	private LocalDate orderDate;
	private int orderCustomerId;
	private String status;
	//@OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
	private Set<Item> orderLineItems=new HashSet<Item>();
	public Order(int orderId, double orderTotal, LocalDate orderDate, int orderCustomerId, String status,
			Set<Item> orderLineItems) {
		super();
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
		this.orderCustomerId = orderCustomerId;
		this.status = status;
		this.orderLineItems = orderLineItems;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Item> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(Set<Item> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderCustomerId;
		result = prime * result + orderId;
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
		Order other = (Order) obj;
		if (orderCustomerId != other.orderCustomerId)
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
	
	
	
		
	
}
