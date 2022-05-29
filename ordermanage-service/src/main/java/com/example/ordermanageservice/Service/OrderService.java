package com.example.ordermanageservice.Service;

import com.itheima.b2b.commonmodule.model.Userorder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
*-*- coding = utf-8 -*-
*@Time : 2022/5/29 16:20
*@Author : 高贵云
*@File : OrderService.java
*@Software : IntelliJ IDEA
*/
@FeignClient(value = "b2b-goods-provider")
@Component
public interface OrderService {


    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET)
    public List<Userorder> getAllorder();

    @RequestMapping(value = "/deleteorder",method = RequestMethod.DELETE)
    public int deleteorder(@RequestParam(value = "id")int id);
}
