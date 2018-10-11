package com.capgemini.orders.controller;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orders.entity.Item;
import com.capgemini.orders.entity.Order;
import com.capgemini.orders.service.OrderService;

@RestController
public class OrderController {

	private HashMap<Integer, Set<Item>> customerCart;
	public OrderController() {
		customerCart = new HashMap<>();
	}

	@Autowired
	private OrderService orderService;
	
	/*@PostMapping("/addtocart/{customerId}")
	public ResponseEntity<Set<Item>> addToCart(@PathVariable int customerId,@RequestBody Item item)
	{
		Set<Item> sampleItem = customerCart.get(customerId);
		if(sampleItem==null)
		{
			sampleItem = new HashSet<>();
			sampleItem.add(item);
			customerCart.put(customerId, sampleItem);
		}
		else
		{
			sampleItem.add(item);
			customerCart.put(customerId, sampleItem);
		}
		ResponseEntity<Set<Item>> responseEntity = new ResponseEntity<Set<Item>>(sampleItem,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/getcartitems/{customerId}")
	public ResponseEntity<Set<Item>> getCartItems(@PathVariable int customerId)
	{
		Set<Item> sampleItem = customerCart.get(customerId);
		ResponseEntity<Set<Item>> responseEntity = new ResponseEntity<Set<Item>>(sampleItem, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@DeleteMapping("/deleteitem/{customerId}")
	public void deleteItem(@RequestBody Item item,@PathVariable int customerId)
	{
		Set<Item> sampleItem = customerCart.get(customerId);
		sampleItem.remove(item);
	}
	
	@GetMapping("/submitorder/{customerId}")
	public ResponseEntity<Order> submitOrder(@PathVariable int customerId)
	{
		Order tempOrder = new Order();
		tempOrder.setOrderCustomerId(customerId);
		tempOrder.setOrderDate(LocalDate.now());
		tempOrder.setOrderId(0);
		tempOrder.setOrderLineItems(customerCart.get(customerId));
		tempOrder.setOrderTotal(0);
		tempOrder.setStatus("PROCESSING");
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(orderService.submitOrder(tempOrder),HttpStatus.OK);
		return responseEntity;
	}*/
	
	@PostMapping("/order")
	public ResponseEntity<Order> sendOrder(@RequestBody Order order)
	{
		ResponseEntity<Order> responseEntity= new ResponseEntity<Order>(orderService.submitOrder(order),HttpStatus.OK);
		return responseEntity;
	}
	/*@DeleteMapping("/removeorder")
	public ResponseEntity<Order>*/
	@GetMapping("/deleteorder/{orderId}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int orderId)
	{
		ResponseEntity<Order> responseEntity=new ResponseEntity<Order>(orderService.deleteOrder(orderId),HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/cancelorder/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int orderId)
	{
		ResponseEntity<Order> responseEntity= new ResponseEntity<Order>(orderService.cancelOrder(orderId),HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable int orderId)
	{
	ResponseEntity<Order> responseEntity=new ResponseEntity<Order>(orderService.getOrder(orderId),HttpStatus.OK);
	return responseEntity;
	}
	@GetMapping("/orders/{customerId}")
	public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable int customerId)
	{
		
		ResponseEntity<List<Order>> responseEntity=new ResponseEntity<List<Order>>(orderService.getOrderByCustomerId(customerId),HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/orderss")
	public ResponseEntity<List<Order>> getOrders(){
		
		ResponseEntity<List<Order>> responseEntity=new ResponseEntity<List<Order>>(orderService.getOrders() ,HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/updateorder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order)
	{
		ResponseEntity<Order> responseEntity= new ResponseEntity<Order>(orderService.updateOrder(order),HttpStatus.OK);
		return responseEntity;
	}
	
	
}
