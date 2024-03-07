package com.example.dependency.example2.model;

import org.springframework.stereotype.Component;

@Component("postgre")
public class PostgreSqlConnector extends DatabaseConnector{

    @Override
    public String connect() {
        return "Connect Postgre: "+getUrl();
    }
}
