package com.capgemini.orders.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orders.entity.Order;
import com.capgemini.orders.repository.OrderRepository;
import com.capgemini.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	/*
	 * @Override public List<Order> getOrders() { // TODO Auto-generated method stub
	 * return orderRepository.findAll(); }
	 * 
	 * @Override public List<Order> getOrderByCustomerId(int customerId) { // TODO
	 * Auto-generated method stub return
	 * orderRepository.findByOrderCustomerId(customerId); }
	 * 
	 * @Override public Order getOrder(int orderId) { // TODO Auto-generated method
	 * stub Optional<Order> optionalOrder = orderRepository.findById(orderId);
	 * if(optionalOrder.isPresent()) return optionalOrder.get(); return null; }
	 */

	@Override
	public Order submitOrder(Order order) {
		order.setOrderDate(LocalDate.now());
		return orderRepository.save(order);
	}

	@Override
	public Order cancelOrder(int orderId) {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			order.setStatus("CANCELLED");
			return orderRepository.save(order);

		}
		return null;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> listorder = orderRepository.findAll();
		return listorder;
	}

	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		List<Order> listorder = orderRepository.findByOrderCustomerId(customerId);

		return listorder;
	}

	@Override
	public Order getOrder(int orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			orderRepository.save(order);
			return order;
		}
		return null;
	}

	@Override
	public Order updateOrder(Order order) {

		order.setStatus("Updated");
	

		return 	orderRepository.save(order);
	}

	@Override
	public Order deleteOrder(int orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			order.setStatus("DELETED");
			orderRepository.save(order);
			return order;

		}
		return null;

	}

}
