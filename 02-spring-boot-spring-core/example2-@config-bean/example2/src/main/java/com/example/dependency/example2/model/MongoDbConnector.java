package com.example.dependency.example2.model;

import org.springframework.stereotype.Component;

@Component("mongodb")
public class MongoDbConnector extends DatabaseConnector{

    @Override
    public String connect() {
        return "Connect MoboDB: "+getUrl();
    }
}
