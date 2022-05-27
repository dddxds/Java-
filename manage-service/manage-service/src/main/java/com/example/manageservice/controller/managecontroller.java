package com.example.manageservice.controller;

import com.example.manageservice.service.GoodService;
import com.itheima.b2b.commonmodule.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/27 17:01
 * @Author : 高贵云
 * @File : managecontroller.java
 * @Software : IntelliJ IDEA
 */
@Controller
@RequestMapping("/manage")
public class managecontroller {
    @Autowired
    private GoodService goodService;
    @GetMapping("/getAllgoods")
    public String managegoods(Model model){
        List<Goods> allgoods = goodService.getAllgoods();
        model.addAttribute("allgoods",allgoods);
        return  "goodmanage";

    }
    @RequestMapping(value = "/deletegood" ,method = RequestMethod.DELETE)
    public String deletegoods(int gid){
        int i= goodService.deletegoods(gid);
        if (i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败了");
        }
        return "getAllgoods";
    }
    @PostMapping("/updategood")
    public String updateGood(Goods good){
        System.out.println(good.toString());
        int i=goodService.updategoods(good);
        if (i==1){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败了");
        }
        return "redirect:getAllgoods";
    }

}
