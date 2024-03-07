package com.luv2code.springboot.thymleafdemo;

import com.luv2code.springboot.thymleafdemo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Đinh","Hữu Nam","dinhhuunam.job@gmail.com"));
        employees.add(new Employee("Đồng","Thị Hà","dongthiha.job@gmail.com"));
        employees.add(new Employee("Phạm","Quỳnh Chi","quynhchi.job@gmail.com"));
        employees.add(new Employee("Đinh","Văn Ro","dinhvanro.job@gmail.com"));
        employees.add(new Employee("Đinh","Thị Nhung","dinhthinhung.job@gmail.com"));
        employees.add(new Employee("Trần","Trọng Hiếu","trantronghieu@gmail.com"));

        List<Employee> results = new ArrayList<>();
        String res = "CHI";
        res=res.toLowerCase();
        for(Employee employee : employees){
            String firstName = employee.getFirstName().toLowerCase();
            String lastName = employee.getLastName().toLowerCase();
            String email = employee.getEmail().toLowerCase();

            if(firstName.contains(res) || lastName.contains(res) || email.contains(res)){
                results.add(employee);
            }
        }

        for(Employee employee:results){
            System.out.println(employee);
        }
    }
}
