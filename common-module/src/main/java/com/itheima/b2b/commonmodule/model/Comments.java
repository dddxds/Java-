package com.itheima.b2b.commonmodule.model;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/28 18:24
 * @Author : 高贵云
 * @File : Comments.java
 * @Software : IntelliJ IDEA
 */

public class Comments {
    public int gid;
    public int cid;
    public String uname;
    public String comment;

    @Override
    public String toString() {
        return "Comments{" +
                "gid=" + gid +
                ", cid=" + cid +
                ", uname='" + uname + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
