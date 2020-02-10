package com.example.routingandfilteringgateway.filters.pre;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class PreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getAttribute("TEST_HEADER") == null) {
            String sessionId = UUID.randomUUID().toString();
            ctx.addZuulRequestHeader("TEST_HEADER", sessionId);
        }
        log.info(String.format("%s filter#%s : %s request to %s with Request Header : %s",
                this.filterType(), this.filterOrder(), request.getMethod(), request.getRequestURL().toString(), ctx.getZuulRequestHeaders()));
        return null;
    }

}