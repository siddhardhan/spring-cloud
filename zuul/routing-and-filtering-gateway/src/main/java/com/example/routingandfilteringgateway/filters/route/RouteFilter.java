package com.example.routingandfilteringgateway.filters.route;

import com.example.routingandfilteringgateway.filters.post.PostFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;

public class RouteFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(RouteFilter.class);

    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info(String.format("Route  filter#%s in action.", this.filterOrder()));
        return null;
    }
}
