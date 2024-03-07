package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.entity.Employee;
import com.luv2code.springboot.thymleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String listEmployee(Model theModel){
        //get the employees from db
        //List<Employee> employees = employeeService.findAll();
        //add to the spring model
        //theModel.addAttribute("employees",employees);
        return listByPage(theModel,1);
    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model theModel,
                             @PathVariable("pageNumber") int currentPage){
        Page< Employee > page = employeeService.findPaginated(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List < Employee > employees = page.getContent();

        theModel.addAttribute("currentPage",currentPage);
        theModel.addAttribute("totalItems",totalItems);
        theModel.addAttribute("totalPages",totalPages);
        theModel.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){

        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);
        //send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //use a redirector to prevent duplicate submissions
        if(theEmployee.getFirstName()=="" || theEmployee.getLastName()=="" ||
        theEmployee.getEmail()==""){
            return "employees/employee-form";
        }
        //save the employee
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        System.out.println(theEmployee);
        //delete employee
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword,Model theModel){
        List<Employee> result = employeeService.search(keyword);
        theModel.addAttribute("employees",result);
        System.out.println(result);
        return "employees/search-employees";
    }

    @GetMapping("/showDetail")
    public String showDetail(@RequestParam("employeeId") int theId, Model theModel){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        System.out.println(theEmployee);

        theModel.addAttribute("employee",theEmployee);
        return "employees/detail-employee";
    }
}