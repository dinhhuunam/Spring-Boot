package com.luv2code.springboot.thymleafdemo.service;

import com.luv2code.springboot.thymleafdemo.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findAllSort();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

    public List<Employee> search(String keyword);

    Page<Employee> findPaginated(int pageNumber);
}
