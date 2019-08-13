package com.demo.service.impl;

import com.demo.entities.Order;
import com.demo.model.CustomerOrders;
import com.demo.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private CustomerOrders customerOrders = CustomerOrders.getInstance();
	@Override
	public Order createOrder(Integer noOfBricks) {
		// TODO Auto-generated method stub
		return customerOrders.createOrder(noOfBricks);
	}

	@Override
	public Order getOrders(Integer orderId) {
		// TODO Auto-generated method stub
		return customerOrders.getOrders(orderId);
	}

	@Override
	public Order updateOrder(Order order, Integer noOfBricks) {
		// TODO Auto-generated method stub
		return customerOrders.updateOrder(order, noOfBricks);
	}

	@Override
	public String fulfillOrder(Order order) {
		// TODO Auto-generated method stub
		return customerOrders.fulfillOrder(order);
	}

	@Override
	public String getAllOrders() {
		// TODO Auto-generated method stub
		return customerOrders.getAllOrders();
	}

}
