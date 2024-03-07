package com.luve2code.springboot.cruddemo.dao;

import com.luve2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    //get Employee by id
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
