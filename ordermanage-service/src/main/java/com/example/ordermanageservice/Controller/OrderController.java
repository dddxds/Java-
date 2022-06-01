package com.example.ordermanageservice.Controller;

import com.example.ordermanageservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/29 17:08
 * @Author : 高贵云
 * @File : OrderController.java
 * @Software : IntelliJ IDEA
 */
@Controller
@RequestMapping("/ordermanage")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/getAllOrder")
    public String getallorder(Model model){
        model.addAttribute("allorder",orderService.getAllorder());
        return "ordermanage";
    }

    @RequestMapping("/deleteorder")
    public String deleteorder(int id){
        orderService.deleteorder(id);
        return "redirect:getAllOrder";
    }
}
