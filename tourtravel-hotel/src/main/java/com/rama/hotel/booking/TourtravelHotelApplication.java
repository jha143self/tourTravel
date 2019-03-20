package com.rama.hotel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.rama.hotel.booking")
@EnableTransactionManagement
public class TourtravelHotelApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TourtravelHotelApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TourtravelHotelApplication.class);
    }
}
