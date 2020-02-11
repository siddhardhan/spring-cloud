package com.example.routingandfilteringgateway;

import com.example.routingandfilteringgateway.filters.error.ErrorFilter;
import com.example.routingandfilteringgateway.filters.post.PostFilter;
import com.example.routingandfilteringgateway.filters.pre.PreFilter;
import com.example.routingandfilteringgateway.filters.route.RouteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@SpringBootApplication
@EnableSwagger2
public class RoutingAndFilteringGatewayApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(RoutingAndFilteringGatewayApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(RoutingAndFilteringGatewayApplication.class, args);
		} catch (Exception e) {
			LOGGER.info("Exception : {}", e.fillInStackTrace());
		}
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	/*@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}*/
}
