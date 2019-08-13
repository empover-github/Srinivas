package com.demo.app;

import com.demo.controller.OrderController;
import com.demo.controller.impl.OrderControllerImpl;
import com.demo.entities.Order;

public class App {

	private static OrderController controller = new OrderControllerImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = createOrder(5);
		
		createOrder(15);
		
		getOrders(order.getOrderId());
		
		updateOrder(order, 10);
		
		fulfillOrder(order);
		
		getAllOrders();
	}
	
	public static Order createOrder(int noOfBricks) {
		Order orderResult = controller.createOrder(noOfBricks);
		System.out.println("Order Created : "+orderResult);
		return orderResult;
	}
	
	public static void getOrders(Integer orderId) {
		// TODO Auto-generated method stub
		System.out.println("Getting valid Order : "+controller.getOrders(orderId));
		
	}

	public static void updateOrder(Order order, int noOfBricks) {
		// TODO Auto-generated method stub
		Order orderResult = controller.updateOrder(order, noOfBricks);
		System.out.println("Updated Order : "+orderResult);
	}
	
	public static void fulfillOrder(Order order) {
		// TODO Auto-generated method stub
		String result = controller.fulfillOrder(order);
		if(result != null && result.equals("SUCCESS")) 
			result = "Order Dispatched";
		System.out.println(result);
	}
	
	public static void getAllOrders() {
		String orders = controller.getAllOrders();
		System.out.println("All Orders : "+orders);
	}
}
