package com.luv2code.springboot.thymleafdemo.dao;

import com.luv2code.springboot.thymleafdemo.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//
//    // that's it ... no need to write any code LOL!
//
//    //add a method to sort by last name
//    public List<Employee> findAllByOrderByLastNameAsc();
//
//    @Query(value = "SELECT c FROM Employee c WHERE c.firstName LIKE '%'|| :keyword || '%'"
//            + "OR c.lastName LIKE '%' || :keyword || '%'"
//            + "OR c.email LIKE '%' || :keyword || '%'")
//    public List<Employee> search(@Param("keyword") String keyword);
//}

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    // that's it ... no need to write any code LOL!

    //add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

    @Query(value = "SELECT c FROM Employee c WHERE c.firstName LIKE '%'|| :keyword || '%'"
            + "OR c.lastName LIKE '%' || :keyword || '%'"
            + "OR c.email LIKE '%' || :keyword || '%'")
    public List<Employee> search(@Param("keyword") String keyword);
}