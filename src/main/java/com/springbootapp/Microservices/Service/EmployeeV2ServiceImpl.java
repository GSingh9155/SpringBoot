package com.springbootapp.Microservices.Service;

import com.springbootapp.Microservices.Entity.EmployeeEntity;
import com.springbootapp.Microservices.Exception.EmployeeNotFoundException;
import com.springbootapp.Microservices.Model.Employee;
import com.springbootapp.Microservices.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmail().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeRepository.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntityList
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                })
                .collect(Collectors.toList());


        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        EmployeeEntity entity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(entity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Successfully deleted Employee with Employee ID: "+ id;
    }
}
