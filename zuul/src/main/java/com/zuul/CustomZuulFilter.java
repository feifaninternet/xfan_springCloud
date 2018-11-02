package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xfan
 * @date Created on 2018/4/4 -- 14:25
 * @desc Zuul 实现服务过滤
 */
@Component
public class CustomZuulFilter extends ZuulFilter{

    /**
     * 返回过滤器类型，zuul 中有 4 中不同的过滤器类型
     * 1. pre : 路由之前
     * 2. routing : 路由之时
     * 3. post : 路由之后
     * 4. error : 发生错误之后
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写判断逻辑，针对不同条件判断是否需要过滤,true 表示需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 这里是过滤逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getHeader("token");
        if(StringUtils.isBlank(accessToken)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
