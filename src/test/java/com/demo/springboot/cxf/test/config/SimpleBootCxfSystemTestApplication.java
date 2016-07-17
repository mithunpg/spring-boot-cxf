/**
 *
 */
package com.demo.springboot.cxf.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author mpissa
 *
 */
@SpringBootApplication
@Import(WebServiceSystemTestConfiguration.class)
public class SimpleBootCxfSystemTestApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SimpleBootCxfSystemTestApplication.class, args);
	}

}
