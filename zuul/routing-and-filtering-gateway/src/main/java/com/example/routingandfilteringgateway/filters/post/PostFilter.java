package com.example.routingandfilteringgateway.filters.post;

import com.example.routingandfilteringgateway.filters.pre.PreFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

public class PostFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s filter#%s : %s request to %s with Request Header : %s",
                this.filterType(), this.filterOrder(), request.getMethod(), request.getRequestURL().toString(), ctx.getZuulRequestHeaders()));
        return null;
    }
}
