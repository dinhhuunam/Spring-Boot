package com.example.dependency.dependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DependencyApplication.class, args);

		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: "+outfit);

		outfit.wear();

//		Girl girl = context.getBean(Girl.class);
//		System.out.println("Instance: "+girl);
//		girl.getOutfit();

		Girl girl = context.getBean(Girl.class);
		System.out.println("Girl instance: "+girl);
		System.out.println("Girl outfit: "+ girl.getOutfit());

		girl.getOutfit().wear();
	}

}
