package luv2code.demo.springboorestapiadvance.controller;

import jakarta.annotation.PostConstruct;
import luv2code.demo.springboorestapiadvance.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> students;

    @PostConstruct
    public void addStudent(){
        students = new ArrayList<>();
        students.add(new Student(1,"Đinh","Hữu Nam"));
        students.add(new Student(2,"Đinh","Văn Ro"));
        students.add(new Student(3,"Đồng","Thị Hà"));
        students.add(new Student(4,"Đinh","Thị Nhung"));
    }

    // http://localhost:8080/student
//    @GetMapping("/student")
//    public Student getStudent(){
//        Student student = new Student(
//                1,
//                "Đinh",
//                "Hữu Nam"
//        );
//        return student;
//    }
//    @GetMapping("/students")
//    public List<Student> getStudents(){
//        return students;
//    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Đinh",
                "Hữu Nam"
        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Nam")
                .body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1
//    @GetMapping("/students/{id}")
//    public Student studentPathVariable(@PathVariable("id")  int studentId){
//        System.out.println(studentId);
//        return students.get(studentId);
//    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id")  int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok(students.get(studentId));
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentDetail(@PathVariable("id") int studentId,
                                    @PathVariable("first-name") String firstName,
                                    @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8080/student?id=1
//    @GetMapping("/students/query")
//    public Student studentRequestVariable(@RequestParam int id){
//        return new Student(id,"Đinh","Văn Tuyên");
//    }

    // Spring Boot REST API with Request Param
    // http://localhost:8080/student?id=1&firstName=Dinh&lastName=Nam
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                              @RequestParam String firstName,
                                              @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //Spring Boot REST API that handles HTTP POST Request - creating new resource
    //@RequestBody annotation is responsible for retrieving the HTTP request body and
    //automatically converting it to the Java object
//    @PostMapping("students/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student){
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("/students/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        Student temp = students.get(0);
        temp.setLastName(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring Boot REST API that handles HTTP DELETE Request - deleting the existing resource
//    @DeleteMapping("students/{id}/delete")
//    public String deleteStudent(@PathVariable("id") int studentId){
//        System.out.println(studentId);
//        return "Student delete successfully " + Integer.toString(studentId);
//    }

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student delete successfully " + Integer.toString(studentId)) ;
    }
}