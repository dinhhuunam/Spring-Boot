package com.luve2code.demo.rest;

import com.luve2code.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for "/student" - return a list students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Đinh","Nam"));
        theStudents.add(new Student("Đỗ","Hà"));
        theStudents.add(new Student("Peter","John"));

        return theStudents;
    }
}
