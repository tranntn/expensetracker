package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void namedQueriesJPQL(){
        Student student = studentRepository.findByFirstNameOrLastNameJPQL("Tran", "Nguyen");
        System.out.println(student.getEmail());
    }

    @Test
    void namedQueriesSQL(){
        Student student = studentRepository.findByFirstNameOrLastNameSQL("Tran", "Nguyen");
            System.out.println(student.getEmail());
    }
}
