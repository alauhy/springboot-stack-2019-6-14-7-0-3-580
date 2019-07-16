package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeImpl {
    Employee findByID(String employeeID);
    List<Employee> findAll();
    void addEmployee(Employee employee);
    List<Employee> findByAge(int age);

    void updateById(String employeeID, Employee employee);
    void deleteByID(String employeeID);
}
