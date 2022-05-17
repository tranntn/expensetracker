package com.udemy.expensetrackerapi.controller;

import com.udemy.expensetrackerapi.entity.Employee;
import com.udemy.expensetrackerapi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employee saveEmployee (@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
}
