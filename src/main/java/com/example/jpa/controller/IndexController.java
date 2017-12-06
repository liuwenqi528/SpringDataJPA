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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ProductService productService;

    @RequestMapping("toIndex")
    public String toIndex() {
        return "index";
    }

    //    无参数分页
    @RequestMapping("listProductPage")
    public String listOfPage(Integer pageNo, Model model) {

        Page<Product> pList = productService.findAll(pageNo);

        model.addAttribute("pList", pList);
//        long total = pList.getTotalElements();//总条数
//        System.out.println("设置的分页每页显示数量 =="+pList.getSize());
//        System.out.println("查询到的分页数据的数量===" + pList.getNumberOfElements());

        System.out.println("----------------------------------------------");
        System.out.println("判断是否有上一页 ==" + pList.hasPrevious());
        System.out.println("获取每页显示的数量（如果没有上一页则取值1） ===" + (pList.hasPrevious() ? pList.previousPageable().getPageSize() : 1));
        System.out.println("获取上一页的页码（如果没有上一页则取值1）===" + (pList.hasPrevious() ? pList.previousPageable().next().getPageNumber() : 1));
        System.out.println("----------------------------------------------");
        System.out.println("判断是否有下一页===" + pList.hasNext());
        System.out.println("获取每页显示的数量（如果没有下一页则取值最大页数）===" + (pList.hasNext() ? pList.nextPageable().getPageSize() : pList.getTotalPages()));
        System.out.println("获取下一页的页码（如果没有下一页则取值最大页数） ===" + (pList.hasNext() ? pList.nextPageable().next().getPageNumber() : pList.getTotalPages()));
        System.out.println("----------------------------------------------");

        System.out.println("总页数 ===" + pList.getTotalPages());
        return "index";
    }
    @RequestMapping("byParams")
    public String listOfPageByParams(Product product,Integer pageNo,Model model){
        Page<Product> pList = productService.findAll(product,pageNo);

        model.addAttribute("pList", pList);

        return "index";
    }





    //    测试JPA根据name属性名称查询Product
    @RequestMapping("/productByName")
    @ResponseBody
    public List<Product> listProductByName(String name) {
        List<Product> list = productService.findByName(name);
        return list;
    }

    //    测试JPA根据name属性名称查询Product
    @RequestMapping("/productByNameAndPrice")
    @ResponseBody
    public List<Product> listProductByName(String name, BigDecimal price) {
        List<Product> list = productService.findByNameAndPrice(name, price);
        return list;
    }
}
