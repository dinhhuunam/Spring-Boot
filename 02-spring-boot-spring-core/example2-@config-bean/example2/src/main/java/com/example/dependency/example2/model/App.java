package com.example.dependency.example2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Autowired
    @Qualifier("mysql")
    private DatabaseConnector database;

    public void connectMysql(@Qualifier("mysql") DatabaseConnector database){
        this.database = database;
        database.setUrl("jdbc:mysql://host1:33060/loda");
        System.out.println(database.connect());
    }
}
