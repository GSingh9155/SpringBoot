package com.springbootapp.Microservices.Service;

import com.springbootapp.Microservices.Exception.EmployeeNotFoundException;
import com.springbootapp.Microservices.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmail().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {

        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException( "" + "Employee not found with id: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees.stream()
                .filter(employee1 -> employee1.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(employee);

        return "Successfully deleted Employee with Employee ID: "+ id;
    }
}
