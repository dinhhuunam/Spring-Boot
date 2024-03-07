package com.luv2code.springboot.thymleafdemo.service;

import com.luv2code.springboot.thymleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllSort() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> search(String keyword) {
        List<Employee> theEmployees = employeeRepository.findAll();
        List<Employee> result = new ArrayList<>();
        keyword = keyword.toLowerCase();
        for(Employee employee : theEmployees){
            String firstName = employee.getFirstName().toLowerCase();
            String lastName = employee.getLastName().toLowerCase();
            String email = employee.getEmail().toLowerCase();

            if(firstName.contains(keyword) || lastName.contains(keyword) || email.contains(keyword)){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Page<Employee> findPaginated(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber-1 , 5);
        return employeeRepository.findAll(pageable);
    }
}