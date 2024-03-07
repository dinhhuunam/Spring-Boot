package com.example.dependency.example2.rest;

import com.example.dependency.example2.config.AppConfig;
import com.example.dependency.example2.model.App;
import com.example.dependency.example2.model.DatabaseConnector;
import com.example.dependency.example2.model.MySqlConnector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.example.dependency.example2.model")
public class Controller {
    private App newApp;

//    @GetMapping("/mysql")
//    public String connectMysql(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
//        return mysql.connect();
//    }
//
//    @GetMapping("/mongodb")
//    public String connectMongodb(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");
//        return mongodb.connect();
//    }
//
//    @GetMapping("/postgredb")
//    public String connectpstgredb(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        DatabaseConnector postgre = (DatabaseConnector) context.getBean("postgresqlConnector");
//        return postgre.connect();
//    }


    public Controller(App newApp) {
        this.newApp = newApp;
    }

    @GetMapping("/mysql")
    public void connect(@Qualifier("mysql") MySqlConnector mysql){
        newApp.connectMysql(mysql);
    }
}
