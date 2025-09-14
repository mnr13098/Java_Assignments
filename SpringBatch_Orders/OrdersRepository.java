package com.example.springBatchDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBatchDemo.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
