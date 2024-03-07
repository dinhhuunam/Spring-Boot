package com.example.dependency.example2;

import com.example.dependency.example2.config.AppConfig;
import com.example.dependency.example2.model.DatabaseConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.dependency.example2.rest")
public class Example2Application {

	public static void main(String[] args) {

		SpringApplication.run(Example2Application.class, args);
	}

}
