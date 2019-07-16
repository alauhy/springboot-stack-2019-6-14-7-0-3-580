package com.tw.apistackbase;

import com.tw.apistackbase.service.EmployeeService;

public class Test {
    public static void main(String[] args) {
        EmployeeService employeeIml = new EmployeeService();
        System.out.println( employeeIml.findAll());
    }
}
