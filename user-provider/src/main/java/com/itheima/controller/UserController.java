package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.User;
import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "upassword")String
                                upassword, @RequestParam(value = "uname")String uname,
                        @RequestParam(value = "usex") String usex){
        return userDao.register(upassword,uname,usex);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam("uname") String uname){
        System.out.println("提供者的控制层"+uname);
        return userDao.login(uname);
    }
    @RequestMapping(value = "/upload",method = RequestMethod.PUT)
    public int uploud(@RequestBody User user) {
        return userDao.upload(user);
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userDao.getAllUser();

    }
    @RequestMapping(value = "/selectuserbyid",method = RequestMethod.GET)
    public User SelectUserById (@RequestParam(value = "uaccount") String uaccount){
        return userDao.SelectUserById(uaccount);
    }
    @RequestMapping(value = "/updateuser",method = RequestMethod.PUT)
    public int updateUser(@RequestBody User user){
        return userDao.updateUser(user);
    }
   @RequestMapping(value="/deleteusre",method = RequestMethod.DELETE)
    public int deleteUser(@RequestParam(value = "uaccount") String uaccount){
        return userDao.delete(uaccount);
   }

    }

