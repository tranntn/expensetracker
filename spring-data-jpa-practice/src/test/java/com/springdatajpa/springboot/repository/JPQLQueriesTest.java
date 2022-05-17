package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findStudentByFirstNameOrLastNameJPQLIndexedParamMethod(){
        Student student = studentRepository.findStudentByFirstNameOrLastNameJPQLIndexedParam("Tran", "Nguyen");
        System.out.println(student.getEmail());
    }
}
