package com.itheima.dao;

import com.itheima.b2b.commonmodule.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //用户注册接口
    int register(@Param(value = "upassword")String upassword,
                 @Param(value = "uname")String uname,
                 @Param(value = "usex") String usex);

    User login(@Param(value = "uname") String uname);//用户登录接口;

    int upload(User user);

    //获取用户列表
    @Select("select*from user")
    List<User> getAllUser();
    //根据Id查询
    @Select("select*from user where uaccount=#{uaccount}")
    User SelectUserById (String uaccount);
    //修改
    @Update("update user set uname=#{uname},upassword=#{upassword},usex=#{usex} where uaccount=#{uaccount}")
    int updateUser(User user);
    //删除
    @Delete("delete form user where uaccount=#{uaccount}")
    int delete(String uaccount);

}
