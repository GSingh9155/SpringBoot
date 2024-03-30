package com.springbootapp.Microservices.Exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
