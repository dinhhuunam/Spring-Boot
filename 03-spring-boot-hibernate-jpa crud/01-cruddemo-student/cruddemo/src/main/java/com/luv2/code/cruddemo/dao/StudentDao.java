package com.luv2.code.cruddemo.dao;

import com.luv2.code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);

    public Student findById(Integer id);

    List<Student> findAll();

    //Find Student by lastName
    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
