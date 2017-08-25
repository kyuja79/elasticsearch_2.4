package com.gaebalja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gaebalja"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		 1.
//		new SpringApplicationBuilder(Application.class)
//			.properties("spring.config.location=classpath:/application.properties")
//			.run(args);
		
//		 2.
//		new SpringApplicationBuilder(Application.class)
//		.properties("spring.config.name=application")
//		.run(args);
		
//		 3.
//		new SpringApplicationBuilder(Application.class)
//		.listeners(new LoadAdditionalProperties())
//		.run(args);
	}
}
