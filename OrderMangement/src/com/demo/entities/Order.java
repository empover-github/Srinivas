package com.demo.entities;

public class Order {
	private Integer orderId;
	private String orderStatus;
	private Integer brickQuantity;
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(Integer brickQuantity) {
		this.brickQuantity = brickQuantity;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", brickQuantity=" + brickQuantity + "]";
	}
}
