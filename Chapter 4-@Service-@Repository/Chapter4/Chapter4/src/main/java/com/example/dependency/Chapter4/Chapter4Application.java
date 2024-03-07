package com.example.dependency.Chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Chapter4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Chapter4Application.class, args);

		//Lấy ra bean GirlService
		GirlService girlService = context.getBean(GirlService.class);
		//Lấy ra random một cô gái từ tầng service
		Girl girl = girlService.getRandomGirl();
		//In ra man hinh
		System.out.println(girl);
	}

}
