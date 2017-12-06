/**
 * Created by IntelliJ IDEA.
 * User: LiuWenqi
 * Date: 2017-12-04
 * Time: 08:47
 * Description:
 */
package com.example.jpa.service.impl;

import com.example.jpa.dao.OrderLineRepository;
import com.example.jpa.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;
}
