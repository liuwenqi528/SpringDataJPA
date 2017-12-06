package com.example.jpa.service;

import com.example.jpa.entity.Customer;

public interface CustomerService {
    Customer findById(Integer id);
}
