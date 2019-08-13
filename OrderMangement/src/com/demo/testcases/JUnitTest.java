package com.demo.testcases;

import org.junit.Assert;
import org.junit.Test;

import com.demo.controller.OrderController;
import com.demo.controller.impl.OrderControllerImpl;
import com.demo.entities.Order;

public class JUnitTest {
	private OrderController controller = new OrderControllerImpl();
	
	
// To verify Order Creation for number of bricks
	@Test
	public void test1()
	{
		Integer expectedResult = 5;
		Order order = controller.createOrder(5);
		System.out.println("Testcase1 Order Created : "+order);
		Assert.assertEquals("Order Quantity: " , expectedResult, order.getBrickQuantity());	
	}
	
	// To Verify order reference is unique
		@Test
		public void test2()
		{
			Integer expectedResult = 2;
			Order order = controller.createOrder(15);
			System.out.println("Testcase2 Order Created for verifying unique reference No : "+order);
			Assert.assertEquals("Order ID is: " , expectedResult, order.getOrderId());	
		}
	
	//To verify retrieve the Order with valid reference number
	@Test
	public void test3()
	{
		Integer expectedResult = 5;
		Order order = controller.getOrders(1);
		System.out.println("Testcase3 Getting valid Order : "+order);
		Assert.assertEquals("Order Quantity: " , expectedResult, order.getBrickQuantity());	
	}
	
	//To verify retrieving the Order details with invalid reference number
	@Test
	public void test4()
	{
		Integer expectedResult = null;
		Order order = controller.getOrders(10);
		System.out.println("Testcase4 No Order details are returned");
		Assert.assertEquals("Order Quantity: " , expectedResult, order);	
	}
	
	//	To verify retrieve all the orders
	@Test
	public void test5()
	{
		String orders = controller.getAllOrders();
		System.out.println("Testcase5 All Orders : "+orders);
		boolean expected = false ;
		if(orders != null) {
			expected = true;
		}
		Assert.assertEquals("All Orders : " , true, expected);	
	}
	
	//To verify update order with number of bricks
	@Test
	public void test6()
	{
		Order order = new Order();
		order.setOrderId(1);
		Integer expectedResult = 10;
		order = controller.updateOrder(order, 10);
		System.out.println("Testcase6 Updated Order : "+order);
		Assert.assertEquals("Order Quantity: " , expectedResult, order.getBrickQuantity());	
	}
	
	//	To verify dispatching the Order for a valid order reference Number
	@Test
	public void test7()
	{
		Order order = new Order();
		order.setOrderId(1);
		String expectedResult = "SUCCESS";
		String status = controller.fulfillOrder(order);
		Assert.assertEquals("Order Status : " , expectedResult, status);	
		System.out.println("Testcase7 : Dispatched");
		
	}
	
//	To verify dispatching the order for a invalid order reference number
	@Test
	public void test8()
	{
		Order order = new Order();
		order.setOrderId(10);
		String expectedResult = "400 Bad Request";
		String status = controller.fulfillOrder(order);
		Assert.assertEquals("Order Status: " , expectedResult, status);	
		System.out.println("Testcase8 : 400 Bad Request");
		
	}
	
	//	To verify update order for already dispatched Order
	@Test
	public void test9()
	{
		Order order = new Order();
		order.setOrderId(1);
		String expectedResult = "400 Bad Request";
		order = controller.updateOrder(order, 15);
		System.out.println("Testcase9 Updated Order : "+order.getOrderStatus());
		Assert.assertEquals("Order Quantity: " , expectedResult, order.getOrderStatus());	
	}
	

	
}
