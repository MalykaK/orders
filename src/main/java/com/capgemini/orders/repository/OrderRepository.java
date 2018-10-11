package com.capgemini.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.orders.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	public List<Order> findByOrderCustomerId(int orderCustomerId);
}
