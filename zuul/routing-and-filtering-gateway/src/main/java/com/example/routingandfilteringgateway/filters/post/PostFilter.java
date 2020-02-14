package com.example.routingandfilteringgateway.filters.post;

import com.example.routingandfilteringgateway.filters.pre.PreFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

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
        //RequestContext context = getCurrentContext();
        //return context.getRequest().getParameter("service") == null;
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = getCurrentContext();
        try {
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            context.setResponseBody(body);
        }
        catch (IOException e) {
            rethrowRuntimeException(e);
        }
        HttpServletRequest request = context.getRequest();
        log.info(String.format("%s filter#%s : %s request to %s with Request Header : %s",
                this.filterType(), this.filterOrder(), request.getMethod(), request.getRequestURL().toString(), context.getResponseBody()));
        return null;
    }

}
