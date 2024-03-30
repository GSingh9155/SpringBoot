package com.springbootapp.Microservices.Service;

import com.springbootapp.Microservices.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
