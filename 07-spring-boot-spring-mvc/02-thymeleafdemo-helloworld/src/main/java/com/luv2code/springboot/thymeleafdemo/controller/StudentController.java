package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println(theStudent.getFirstName()+" "+theStudent.getLastName());

        return "process-form";
    }
}
