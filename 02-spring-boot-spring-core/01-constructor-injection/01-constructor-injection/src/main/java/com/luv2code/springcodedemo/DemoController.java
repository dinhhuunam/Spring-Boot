package com.luv2code.springcodedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;
    @Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }
}