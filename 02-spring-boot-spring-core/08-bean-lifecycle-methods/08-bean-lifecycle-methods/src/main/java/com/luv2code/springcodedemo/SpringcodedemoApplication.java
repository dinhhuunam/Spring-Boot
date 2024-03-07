package com.luv2code.springcodedemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication(
//		scanBasePackages = {"com.luv2code.springdemo",
//							"com.luv2code.util"})

//Khi IoC Container (ApplicationContext) tìm thấy một Bean cần quản lý, nó sẽ khởi tạo bằng Constructor
//		inject dependencies vào Bean bằng Setter, và thực hiện các quá trình cài đặt khác vào Bean như setBeanName, setBeanClassLoader, v.v..
//		Hàm đánh dấu @PostConstruct được gọi
//		Tiền xử lý sau khi @PostConstruct được gọi.
//		Bean sẵn sàng để hoạt động
//		Nếu IoC Container không quản lý bean nữa hoặc bị shutdown nó sẽ gọi hàm @PreDestroy trong Bean
//		Xóa Bean.
@SpringBootApplication
public class SpringcodedemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringcodedemoApplication.class, args);
	}

}
