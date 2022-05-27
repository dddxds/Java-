package com.itheima.dao;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface GoodsDao {
    //查询所有商品
    List<Goods> getAllgoods();
    //根据商品名称模糊查找
    List<Goods> getOnegoods(@Param(value = "gname")String gname);
    //根据id查询单个商品详情
    Goods getOnegid(@Param(value = "gid")int gid);
    //增加商品
    @Insert("insert into goods set gname=#{gname}, gremain=#{gmain},gdetails=#{gdetails},gprice=#{gprice},types=#{types}")
    int insertGood(Goods goods);
    //修改商品信息
    @Update("update goods set gname=#{gname}, gremain=#{gmain},gdetails=#{gdetails},gprice=#{gprice} where gid=#{gid}")
    int updateGood(Goods goods);
    //删除商品
    @Delete("delete from goods where gid=#{gid}")
    int deleteGood(int gid);
}
