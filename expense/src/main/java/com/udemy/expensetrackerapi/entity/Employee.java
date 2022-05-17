package com.udemy.expensetrackerapi.entity;

import com.udemy.expensetrackerapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity(name = "Employee")
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest request){
        this.name = request.getName();
    }

    public Employee(){

    }
}
