package com.luv2code.springcodedemo.rest;

import com.luv2code.springcodedemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach myCoach) {
        System.out.println("In constructor: "+getClass().getSimpleName());
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }
}