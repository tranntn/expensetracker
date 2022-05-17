package com.udemy.expensetrackerapi.service;

import com.udemy.expensetrackerapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);
}
