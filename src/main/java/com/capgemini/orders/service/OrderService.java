package com.capgemini.orders.service;

import java.util.List;

import com.capgemini.orders.entity.Order;

public interface OrderService {

	public List<Order> getOrders();
	public List<Order> getOrderByCustomerId(int customerId);
	public Order getOrder(int orderId);
	public Order submitOrder(Order order);
	public Order updateOrder(Order order);
	public Order deleteOrder(int orderId);
	public Order cancelOrder(int orderId);
	
}
