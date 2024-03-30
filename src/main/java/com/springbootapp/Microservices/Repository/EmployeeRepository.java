package com.springbootapp.Microservices.Repository;

import com.springbootapp.Microservices.Entity.EmployeeEntity;
import com.springbootapp.Microservices.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}
