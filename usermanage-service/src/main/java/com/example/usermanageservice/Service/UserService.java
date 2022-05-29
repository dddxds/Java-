package com.example.usermanageservice.Service;

import com.itheima.b2b.commonmodule.model.User;
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
 * @Time : 2022/5/28 20:57
 * @Author : 高贵云
 * @File : UserService.java
 * @Software : IntelliJ IDEA
 */
@FeignClient(value = "b2b-user-provider")
@Component
public interface UserService {

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser();

    @RequestMapping(value = "/selectuserbyid",method = RequestMethod.GET)
    public User SelectUserById (@RequestParam(value = "uaccount") String uaccount);
    @RequestMapping(value = "/updateuser",method = RequestMethod.PUT)
    public int updateUser(@RequestBody User user);
    @RequestMapping(value="/deleteusre",method = RequestMethod.DELETE)
    public int deleteUser(@RequestParam("uaccount") String uaccount);
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public  int register(@RequestParam(value = "upassword")String upassword, @RequestParam(value = "uname")String uname, @RequestParam(value = "usex") String usex);
}
