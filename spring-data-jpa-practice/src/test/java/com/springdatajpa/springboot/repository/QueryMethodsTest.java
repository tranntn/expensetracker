package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findByFirstNameMethod(){
        List<Student> students = studentRepository.findDistinctByFirstName("Nam Phuong");
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByFirstNameAndLastNameMethod(){
        List<Student> students = studentRepository.findDistinctByFirstNameAndLastName("Nam Phuong", "Tran");
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByFirstNameOrLastNameMethod(){
        List<Student> students = studentRepository.findByFirstNameOrLastName("Tung", "Tran");
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByLastNameLikeMethod(){
        List<Student> students = studentRepository.findByLastNameLike("an");
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByFirstNameContainingMethod(){
        List<Student> students = studentRepository.findByFirstNameContaining("Tran");
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2022,05,17,11,13,47);
        LocalDateTime endDate = LocalDateTime.of(2022,05,17,14,36,15);

        List<Student> students = studentRepository.findByDateCreatedBetween(startDate, endDate);
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findByLastNameInMethod(){
        List<Student> students = studentRepository.findByLastNameIn(List.of("Tran", "Bui"));
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findFirst2ByOrderByEmailDescMethod(){
        List<Student> students = studentRepository.findFirst2ByOrderByEmailDesc();
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void findTop3ByOrderByLastNameAscMethod(){
        List<Student> students = studentRepository.findTop3ByOrderByLastNameAsc();
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }
}
