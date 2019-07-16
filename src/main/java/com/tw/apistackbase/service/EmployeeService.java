package com.tw.apistackbase.service;


import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.respository.EmployeeRespostity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeService implements EmployeeImpl {
    @Autowired
    private EmployeeRespostity employeeRespostity;

    @Override
    public Employee findByID(String employeeID) {
        return employeeRespostity.findByID(employeeID);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRespostity.addEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRespostity.getEmployees();
    }

    @Override
    public List<Employee> findByAge(int age) {
        return employeeRespostity.getEmployees().stream().filter(e -> e.getAge() >= age).collect(Collectors.toList());
    }

    @Override
    public void updateById(String employeeID, Employee employee) {
        employeeRespostity.update(employeeID,employee);
    }

    @Override
    public void deleteByID(String employeeID) {
        employeeRespostity.delete(employeeID);
    }
}
