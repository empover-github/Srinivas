package com.demo.controller.impl;

import com.demo.controller.OrderController;
import com.demo.entities.Order;
import com.demo.service.OrderService;
import com.demo.service.impl.OrderServiceImpl;

public class OrderControllerImpl implements OrderController{

	private OrderService orderService = new OrderServiceImpl();
	@Override
	public Order createOrder(Integer noOfBricks) {
		// TODO Auto-generated method stub
		return orderService.createOrder(noOfBricks);
	}

	@Override
	public Order getOrders(Integer orderId) {
		// TODO Auto-generated method stub
		return orderService.getOrders(orderId);
	}

	@Override
	public Order updateOrder(Order order, Integer noOfBricks) {
		// TODO Auto-generated method stub
		return orderService.updateOrder(order, noOfBricks);
	}

	@Override
	public String fulfillOrder(Order order) {
		// TODO Auto-generated method stub
		return orderService.fulfillOrder(order);
	}

	@Override
	public String getAllOrders() {
		// TODO Auto-generated method stub
		return orderService.getAllOrders();
	}

}
