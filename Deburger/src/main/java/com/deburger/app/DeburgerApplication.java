package com.deburger.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.deburger.app.**.mapper")
@SpringBootApplication
public class DeburgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeburgerApplication.class, args);
	}

}
