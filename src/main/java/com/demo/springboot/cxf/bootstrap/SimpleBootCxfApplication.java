package com.demo.springboot.cxf.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demo.springboot.cxf")
public class SimpleBootCxfApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleBootCxfApplication.class);

	public static void main(final String[] args) {
		SimpleBootCxfApplication.LOG.debug("Starting service via SpringBoot configuration...");
		SpringApplication.run(SimpleBootCxfApplication.class, args);
	}

}
