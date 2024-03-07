package com.example.dependency.example2.config;

import com.example.dependency.example2.model.DatabaseConnector;
import com.example.dependency.example2.model.MongoDbConnector;
import com.example.dependency.example2.model.MySqlConnector;
import com.example.dependency.example2.model.PostgreSqlConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure(){
        DatabaseConnector mysqlConnector = new MySqlConnector();
        mysqlConnector.setUrl("jdbc:mysql://host1:33060/loda");
        return mysqlConnector;
    }

    @Bean("mongodbConnector")
    DatabaseConnector mongodbConfigure(){
        DatabaseConnector mongoDbConnector = new MongoDbConnector();
        mongoDbConnector.setUrl("mongodb://mongodb0.example.com:27017/loda");
        return mongoDbConnector;
    }

    @Bean("postgresqlConnector")
    DatabaseConnector postgresqlConfigure(){
        DatabaseConnector postgreSqlConnector = new PostgreSqlConnector();
        postgreSqlConnector.setUrl("postgresql://localhost/loda");
        // Set username, password, format, v.v...
        return postgreSqlConnector;
    }
}
