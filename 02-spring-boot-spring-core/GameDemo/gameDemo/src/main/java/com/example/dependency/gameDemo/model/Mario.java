package com.example.dependency.gameDemo.model;

import org.springframework.stereotype.Component;

//@Component("mario")
public class Mario implements GamingConsole {

    @Override
    public String run() {
        return "Run "+getClass().getSimpleName();
    }

    @Override
    public String top() {
        return "Button top top twice";
    }

    @Override
    public String bottom() {
        return "Button bottom twice";
    }

    @Override
    public String left() {
        return "left left";
    }

    @Override
    public String right() {
        return "right right";
    }
}
