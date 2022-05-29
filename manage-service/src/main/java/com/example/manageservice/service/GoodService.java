package com.example.manageservice.service;

import com.itheima.b2b.commonmodule.model.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/27 17:01
 * @Author : 高贵云
 * @File : goodservice.java
 * @Software : IntelliJ IDEA
 */
@Component
@FeignClient(value="b2b-goods-provider")
public interface GoodService  {

    @RequestMapping(value = "/getAllgoods",method = RequestMethod.GET)
    public List<Goods> getAllgoods();
    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    public List<Goods> getOnegoods(@RequestParam(value = "gname") String
                                           gname);
    @RequestMapping(value = "/getOnegid",method = RequestMethod.GET)
    public Goods getOnegid(@RequestParam(value = "gid") int gid);

    @RequestMapping(value = "/addgoods" ,method = RequestMethod.POST)
    public int addgoods(@RequestBody Goods goods);
    @RequestMapping(value = "/updategoods" ,method = RequestMethod.PUT)
    public int updategoods(@RequestBody Goods goods);
    @RequestMapping(value = "/deletegoods" ,method = RequestMethod.DELETE)
    public int deletegoods(@RequestParam("gid") int gid);

}
