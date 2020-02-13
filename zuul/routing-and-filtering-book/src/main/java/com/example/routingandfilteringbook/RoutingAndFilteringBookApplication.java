package com.example.routingandfilteringbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoutingAndFilteringBookApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(RoutingAndFilteringBookApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(RoutingAndFilteringBookApplication.class, args);
		} catch (Exception e) {
		    LOGGER.info("Exception : {}", e.fillInStackTrace());
		}
	}
}