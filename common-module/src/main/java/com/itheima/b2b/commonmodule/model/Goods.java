package com.itheima.b2b.commonmodule.model;

import java.util.List;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2019-9-25 11:30
 * @Created by CrazyStone
 */

public class Goods {
    public int gid, gprice,gnumber;
    public String gname, gdetails;

    private List<Comments> comments;

    private  Integer types;
    private String gremain;

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gprice=" + gprice +
                ", gnumber=" + gnumber +
                ", gname='" + gname + '\'' +
                ", gdetails='" + gdetails + '\'' +
                ", comments=" + comments +
                ", types=" + types +
                ", gremain='" + gremain + '\'' +
                '}';
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGprice() {
        return gprice;
    }

    public void setGprice(int gprice) {
        this.gprice = gprice;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdetails() {
        return gdetails;
    }

    public void setGdetails(String gdetails) {
        this.gdetails = gdetails;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getGremain() {
        return gremain;
    }

    public void setGremain(String gremain) {
        this.gremain = gremain;
    }

}
