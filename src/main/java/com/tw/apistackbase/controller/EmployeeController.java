package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeService.addEmployee(employee);
    }
    @GetMapping("/employee/{employeeID}")
    public Employee findEmployeeById(@PathVariable String employeeID) {
       return employeeService.findByID(employeeID);
    }
   @GetMapping(path = "/employee/" ,params = "ageMini")
    public List<Employee> findByAge(@RequestParam int age){
        return employeeService.findByAge(age);

   }
   @PutMapping("/employee/{employeeID}")
    public void updateEmployee(@PathVariable String employeeID,@RequestBody Employee employee){
        employeeService.updateById(employeeID,employee);
   }
   @DeleteMapping("/employee/{employeeID}")
    public void deleteEmployee(@PathVariable String employeeID){
        employeeService.deleteByID(employeeID);
   }


}
