package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface employee {
    Employee findByID(String employeeID);
    List<Employee> findAll();
}
