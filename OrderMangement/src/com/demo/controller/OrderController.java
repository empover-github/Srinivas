package com.demo.controller;

import com.demo.entities.Order;

public interface OrderController {
	abstract Order createOrder(Integer noOfBricks);
	abstract Order getOrders(Integer order);
	abstract Order updateOrder(Order order, Integer noOfBricks);
	abstract String fulfillOrder(Order order);
	abstract String getAllOrders();
}
