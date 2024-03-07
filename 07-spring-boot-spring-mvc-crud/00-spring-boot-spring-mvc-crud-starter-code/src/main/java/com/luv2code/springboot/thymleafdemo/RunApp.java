//package com.luv2code.springboot.thymleafdemo;
//
//import com.luv2code.springboot.thymleafdemo.dao.EmployeeRepository;
//import com.luv2code.springboot.thymleafdemo.entity.Employee;
//import com.luv2code.springboot.thymleafdemo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Component;
//
//import java.awt.print.Pageable;
//import java.util.List;
//
//@Component
//public class RunApp implements CommandLineRunner {
//    private EmployeeService employeeService;
//
//    @Autowired
//    public RunApp(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        int pageSize = 3;
//        int pageNo = 1;
//        Page<Employee> page = employeeService.findPaginated(pageNo,pageSize);
//        List<Employee> list = page.getContent();
//        System.out.println(list);
//    }
//}
