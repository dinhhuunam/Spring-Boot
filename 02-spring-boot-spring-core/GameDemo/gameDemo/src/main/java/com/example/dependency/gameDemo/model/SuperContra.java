package com.example.dependency.gameDemo.model;

import org.springframework.stereotype.Component;

//@Component("contra")
public class SuperContra implements GamingConsole{

    @Override
    public String run() {
        return "Run game: "+getClass().getSimpleName();
    }

    @Override
    public String top() {
        return "Jump 1 a week";
    }

    @Override
    public String bottom() {
        return null;
    }

    @Override
    public String left() {
        return null;
    }

    @Override
    public String right() {
        return null;
    }
}
