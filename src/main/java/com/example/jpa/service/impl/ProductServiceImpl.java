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
import org.springframework.data.domain.*;
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
        Pageable pageable = new PageRequest(pageNo-1,3);
        return productRepository.findAll( pageable);
    }

    @Override
    public Page<Product> findAll(Product product, Integer pageNo) {
        Pageable pageable = new PageRequest(pageNo-1,3);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("inStock");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//        Example<Product> example = Example.of(product);//product对象中值不为null的属性全部以确切匹配查询
        Example<Product> example = Example.of(product,matcher);
        return productRepository.findAll(example, pageable);
    }
}
