package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Comments;
import com.itheima.b2b.commonmodule.model.Goods;
import com.itheima.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @RequestMapping(value = "/getAllgoods",method = RequestMethod.GET)
    public List<Goods> getAllgoods(){
        return goodsDao.getAllgoods();
    };
    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    public List<Goods> getOnegoods(@RequestParam(value = "gname")String gname){
        return goodsDao.getOnegoods(gname);
    }
    @RequestMapping(value = "/getOnegid",method = RequestMethod.GET)
    public Goods getOnegid(@RequestParam(value = "gid")int gid){
        Goods goods ;
        goods=goodsDao.getOnegid(gid);
        goods.setComments(goodsDao.getoneComments(gid));
        return goods;
    }
    @RequestMapping(value = "/addgoods" ,method = RequestMethod.POST)
    public int addgoods(@RequestBody Goods goods){
        return goodsDao.insertGood(goods);
    }
    @RequestMapping(value = "/updategoods" ,method = RequestMethod.PUT)
    public int updategoods(@RequestBody Goods goods){

        return goodsDao.updateGood(goods);
    }
    @RequestMapping(value = "/deletegoods" ,method = RequestMethod.DELETE)
    public int deletegoods(@RequestParam("gid") int gid){
        return goodsDao.deleteGood(gid);
    }
    //添加评论
    @RequestMapping(value = "insertcomment",method = RequestMethod.POST)
    int insertComments(@RequestBody Comments comments){
        return goodsDao.insertComments(comments);
    }
    //查询评论
    @RequestMapping(value = "getComments",method = RequestMethod.GET)
    List<Comments> getoneComments(@RequestParam("gid") int gid){
        System.out.println(goodsDao.getoneComments(gid));
        return goodsDao.getoneComments(gid);
    }
    //删除评论
    @RequestMapping(value = "deleteComments",method = RequestMethod.DELETE)
    int deleteComments(@RequestParam("cid") int cid){
        return goodsDao.deleteComments(cid);
    }


}
