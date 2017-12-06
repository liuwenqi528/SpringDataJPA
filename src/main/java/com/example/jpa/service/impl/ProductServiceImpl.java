/**
 * Created by IntelliJ IDEA.
 * User: LiuWenqi
 * Date: 2017-12-02
 * Time: 13:56
 * Description:
 */
package com.example.jpa.service.impl;

import com.example.jpa.dao.ProductRepository;
import com.example.jpa.entity.Product;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Integer  id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByNameAndPrice(String name, BigDecimal price) {
        return productRepository.findByNameAndPrice(name,price);
    }

    @Override
    public Page<Product> findAll(Integer pageNo) {
        Pageable pageable = new PageRequest(pageNo,2);
        return productRepository.findAll( pageable);
    }
}
