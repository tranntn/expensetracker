package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
