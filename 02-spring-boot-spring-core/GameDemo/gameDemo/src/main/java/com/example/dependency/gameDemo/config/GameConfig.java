package com.example.dependency.gameDemo.config;

import com.example.dependency.gameDemo.model.GamingConsole;
import com.example.dependency.gameDemo.model.Mario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean("mario")
    public GamingConsole mario(){
        return new Mario();
//        GamingConsole mario = new Mario();
//        return mario;
    }
}
