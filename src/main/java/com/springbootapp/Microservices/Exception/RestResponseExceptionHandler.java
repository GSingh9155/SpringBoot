package com.springbootapp.Microservices.Exception;

import com.springbootapp.Microservices.Model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return errorMessage;
    }
}
