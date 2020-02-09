package com.example.routingandfilteringbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RoutingAndFilteringBookApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(RoutingAndFilteringBookApplication.class);

	@RequestMapping(value = "/available")
	public String available() {
		return "Spring in Action";
	}

	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		return "Spring Boot in Action";
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(RoutingAndFilteringBookApplication.class, args);
		} catch (Exception e) {
		    LOGGER.info("Exception : {}", e.fillInStackTrace());
		}
	}
}