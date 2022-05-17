package com.udemy.expensetrackerapi.repository;

import com.udemy.expensetrackerapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
