package com.luve2code.demo.rest;

import com.luve2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student....only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Đinh","Nam"));
        theStudents.add(new Student("Đỗ","Hà"));
        theStudents.add(new Student("Peter","John"));
    }
    //define endpoint for "/student" - return a list students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoints or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list...keep it simple for now

        //check the studentId again list size

        if((studentId >= theStudents.size())||(studentId < 0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }

    //Add a exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorRespone
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
