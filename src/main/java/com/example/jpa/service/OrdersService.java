package com.example.jpa.service;

import com.example.jpa.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll();

    Orders findByID(Integer orderId);
}
