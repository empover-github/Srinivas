package com.demo.model;

import java.util.HashMap;
import java.util.Map;

import com.demo.entities.Order;

public class CustomerOrders {
	private static CustomerOrders obj; 
	Integer orderId = 0;
	Integer customerId;
	Integer brickId;
	private Map<Integer, Order> ordersMap = new HashMap<Integer, Order>();
	
	private CustomerOrders() {
		
	}
	public static CustomerOrders getInstance() {
		if (obj==null) 
            obj = new CustomerOrders(); 
        return obj; 
	}
	
	public Order getOrders(Integer orderId){
		if(ordersMap.containsKey(orderId)) {
			return ordersMap.get(orderId);
		}
		return null;
	}
	public Order createOrder(Integer noOfBricks) {
		Order order = new Order();
		if(ordersMap != null && ordersMap.size() >0) {
			orderId = ordersMap.size()+1;
		} else {
			orderId = 1;
		}
		order.setOrderId(orderId);
		order.setBrickQuantity(noOfBricks);
		order.setOrderStatus("Confirmed");
		ordersMap.put(order.getOrderId(), order);
		return order;
	}
	public Order updateOrder(Order order, Integer noOfBricks) {
		if(ordersMap.containsKey(order.getOrderId())) {
			order = ordersMap.get(order.getOrderId());
			
			if(!order.getOrderStatus().equals("DISPATCHED")) 
				order.setBrickQuantity(noOfBricks);
			else 
				order.setOrderStatus("400 Bad Request");
		}
		return order;
	}
	public String fulfillOrder(Order order) {
		if(ordersMap.containsKey(order.getOrderId())) {
			order = ordersMap.get(order.getOrderId());
			if(!order.getOrderStatus().equals("DISPATCHED")) {
				order.setOrderStatus("DISPATCHED");
				return "SUCCESS";
			} else {
				return "400 Bad Request";
			}
		}
		else {
			return "400 Bad Request";
		}
	}
	public String getAllOrders() {
		return ordersMap.toString();
	}
}
