package com.example.springBatchDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {

	@Id
	private long id;
	private String orderDate;
	private String shipMode;
	private String customerId;
	private double sales;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipMode() {
		return shipMode;
	}
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", shipMode=" + shipMode + ", customerId=" + customerId
				+ ", sales=" + sales + "]";
	}
	
	
	
}
