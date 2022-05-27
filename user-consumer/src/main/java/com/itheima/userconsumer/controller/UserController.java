package com.itheima.userconsumer.controller;

import com.itheima.b2b.commonmodule.model.User;
import com.itheima.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;
     //跳转登录界面
    @GetMapping(value = "/tologin")
    public String tologin() {
        return "login";
    }
     // 跳转注册界面
    @GetMapping(value = "/toregister")
    public String toregister() {
        return "register";
    }
    @GetMapping(value = "/toupload")
    public String toupload(HttpSession session,String uaccount) {
        System.out.println( userService.login(uaccount).toString());
        session.setAttribute("user", userService.login(uaccount));

        return "upload";
    }
     // 用户登录
    @GetMapping(value = "/login")
    public String login(String uname, String upassword, HttpServletRequest request) {
        System.out.println("uname===="+uname);
        System.out.println(userService.login(uname));

       if (userService.login(uname) != null) {
           System.out.println("!=null");
            if (userService.login(uname).getUpassword().equals(upassword)){
                // HttpSession session = request.getSession(true);
                // session.setAttribute("user", userService.login(uname));  //将登陆者信息存入session
                System.out.println("------------------------------------");
              return "redirect:http://localhost:8896/goods/getAll?uaccount="+userService.login(uname).getUaccount()+"&upasswoed="+userService.login(uname).getUpassword();
            }
        }
       // request.setAttribute("mag","账号密码错误");
        System.out.print("登录成功");
        return "login";
    }
    //用户注册
    @GetMapping(value = "/register")
    public String register(HttpServletRequest request,String upassword,String uname,String usex) {
       if(userService.register(upassword, uname, usex)>0){
           System.out.print("注册成功");
           return "login";
       }
        System.out.print("注册失败");
        return "register";
    }
    @PostMapping("/upload")
    public String upload(User user, String pwdconfirm,String uaccount){
//        System.out.println(user.toString());
//        System.out.println(uaccount);
//
//        System.out.println(pwdconfirm);

       // uname upassword pwdconfirm usex
       int i= userService.uploud(user);
       if (i==1){
           System.out.println("更新成功");
       }else{
           System.out.println("失败了");
       }



        return "redirect:http://localhost:8896/goods/getAll?uaccount="+user.getUaccount()+"&upasswoed="+user.getUpassword();

    }
}