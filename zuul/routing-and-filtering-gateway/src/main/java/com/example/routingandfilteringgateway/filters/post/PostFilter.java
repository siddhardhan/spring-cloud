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
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info(String.format("Post filter#%s in action.", this.filterOrder()));
        return null;
    }
}
