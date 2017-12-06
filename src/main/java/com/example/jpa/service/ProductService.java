package com.example.jpa.service;


import com.example.jpa.entity.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Integer id) ;

    List<Product> findByName(String name);
    List<Product> findByNameAndPrice(String name, BigDecimal price);

    Page<Product> findAll(Integer pageNo);
}
