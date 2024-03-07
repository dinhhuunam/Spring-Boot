package com.example.dependency.gameDemo.rest;

import com.example.dependency.gameDemo.model.GamingConsole;
import com.example.dependency.gameDemo.model.Mario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.example.dependency.gameDemo.config")
@ComponentScan("com.example.dependency.gameDemo.model")
public class GamingRunner {
    private GamingConsole gamingConsole;
//
//    @GetMapping("/mario")
//    public String playMario(@Qualifier("mario")Mario mario){
//        this.gamingConsole = mario;
//        String res = this.gamingConsole.run()+"\n"
//                +this.gamingConsole.top()+"\n"
//                +this.gamingConsole.bottom()+"\n"
//                +this.gamingConsole.left()+"\n"
//                +this.gamingConsole.right();
//        System.out.println(res);
//        return res;
//    }

    @Autowired
    public GamingRunner(@Qualifier("mario") GamingConsole mario) {
        System.out.println("In constructor: "+getClass().getSimpleName());
        this.gamingConsole = mario;
    }

    @GetMapping("/mario")
    public String playMario(){
        String res = this.gamingConsole.run()+"\n"
                +this.gamingConsole.top()+"\n"
                +this.gamingConsole.bottom()+"\n"
                +this.gamingConsole.left()+"\n"
                +this.gamingConsole.right();
        System.out.println(res);
        return res;
    }
}
