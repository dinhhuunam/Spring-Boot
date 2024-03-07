package com.example.dependency.dependency;

import org.springframework.stereotype.Component;

@Component("bikini")
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Wear Bikini");
    }
}
