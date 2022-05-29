package com.itheima.dao;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Userorder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface OrderDao {
    //查询所有订单
    List<Userorder> getAllorder(@Param(value = "uid")int uid);

    //删除一条订单
    @Delete("delete from userorder where id=#{id}")
    int deleteOrder(int id);

    //真查询所有订单
    @Select("select *from userorder")
    List<Userorder> getAllOrder();
}
