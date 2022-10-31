package com.jarmak.fargartest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
//@ImportResource("classpath:application-context.xml")
public class FargartestApplication {


	private static final Logger logger = LoggerFactory.getLogger(FargartestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FargartestApplication.class, args);
	}

}
