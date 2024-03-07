package com.example.dependency.example2.model;

import org.springframework.stereotype.Component;

@Component("mysql")
public class MySqlConnector extends DatabaseConnector{

    @Override
    public String connect() {
        return "Connect Mysql: "+getUrl();
    }
}
