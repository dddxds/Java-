package com.example.usermanageservice.Controller;

import com.example.usermanageservice.Service.UserService;
import com.itheima.b2b.commonmodule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/28 20:58
 * @Author : 高贵云
 * @File : UserController.java
 * @Software : IntelliJ IDEA
 */
@Controller
@RequestMapping("/usermanage")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAllusers")
    public String manageUsers(Model model){
        List<User> allusers = userService.getAllUser();
        model.addAttribute("allusers",allusers);
        return  "usermanage";

    }
    @RequestMapping(value = "/deleteuser")
    public String deleteusers(String uaccount){
        System.out.println("account="+uaccount);
        int i= userService.deleteUser(uaccount);
        if (i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败了");
        }
        return "redirect:getAllusers";
    }
    @PostMapping("/updateuser")
    public String updateuser(User user){
        System.out.println(user.toString());
        int i=userService.updateUser(user);
        if (i==1){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败了");
        }
        return "redirect:getAllusers";
    }
    @PostMapping("/insertuser")
    public String insertuser
            (@RequestParam(value = "upassword")String upassword,
             @RequestParam(value = "uname")String uname,
             @RequestParam(value = "usex") String usex){

        int i=userService.register(upassword,uname,usex);
        if (i==1){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败了");
        }
        return "redirect:getAllusers";
    }
}
