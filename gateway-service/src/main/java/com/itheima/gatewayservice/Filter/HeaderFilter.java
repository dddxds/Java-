package com.itheima.gatewayservice.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * -*- coding = utf-8 -*-
 *
 * @Time : 2022/5/24 14:58
 * @Author : 高贵云
 * @File : HeaderFilter.java
 * @Software : IntelliJ IDEA
 */

@Component
public class HeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("author", "111111");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        request.getHeader("author");

        return null;
    }
}
