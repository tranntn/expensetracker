package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
