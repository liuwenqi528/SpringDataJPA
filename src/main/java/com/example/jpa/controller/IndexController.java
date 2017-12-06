/**
 * Created by IntelliJ IDEA.
 * User: LiuWenqi
 * Date: 2017-12-05
 * Time: 16:59
 * Description:
 */
package com.example.jpa.controller;

import com.example.jpa.entity.Product;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ProductService productService;
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("listProductPage")
    public String listOfPage(Integer pageNo, Model model){

        Page<Product> pList = productService.findAll(pageNo);

        model.addAttribute("pList",pList.getContent());
        long total = pList.getTotalElements();
        System.out.println("total=="+total);
        return "index";
    }

//    测试JPA根据name属性名称查询Product
    @RequestMapping("/productByName")
    @ResponseBody
    public List<Product> listProductByName(String name){
        List<Product> list =productService.findByName(name);
        return list;
    }
    //    测试JPA根据name属性名称查询Product
    @RequestMapping("/productByNameAndPrice")
    @ResponseBody
    public List<Product> listProductByName(String name, BigDecimal price){
        List<Product> list =productService.findByNameAndPrice(name,price);
        return list;
    }
}
