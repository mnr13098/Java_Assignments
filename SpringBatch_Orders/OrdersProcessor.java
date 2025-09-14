package com.example.springBatchDemo.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.springBatchDemo.entity.Orders;

public class OrdersProcessor implements ItemProcessor<Orders, Orders>{

	@Override
	public Orders process(Orders item) throws Exception {
		item.setSales(Math.round(item.getSales()));

		return item;
	}

}
