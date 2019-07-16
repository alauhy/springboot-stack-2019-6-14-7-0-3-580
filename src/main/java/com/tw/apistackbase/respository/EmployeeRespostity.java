package com.tw.apistackbase.respository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sun.misc.Contended;

import java.util.*;
import java.util.stream.Collectors;
@Repository
public class EmployeeRespostity {
    public static Map<String, Employee> employees = new HashMap<>();
    static {
        employees.put("111",createEmployee());
        employees.put("222",createEmployee());
        employees.put("333",createEmployee());
    }
    static public Employee createEmployee(){
        Employee employee = new Employee();
        employee.setAge(11);
        employee.setGendar("FEMALE");
        employee.setName("XY");
        employee.setId(UUID.randomUUID().toString());
        return employee;
    }
   public void addEmployee(Employee employee){
        String employeesID = UUID.randomUUID().toString();
        employee.setId(employeesID);
        employees.put(employeesID,employee);
    }

    public List<Employee> getEmployees() {
    return employees.values().stream().collect(Collectors.toList());
    }

    public Employee findByID(String employeeID) {
        return employees.get(employeeID);
    }

    public void update(String employeeID, Employee employee) {
        employees.remove(employeeID);
        employee.setId(employeeID);
        employees.put(employeeID,employee);

    }

    public void delete(String employeeID) {
        employees.remove(employeeID);
    }
}
