package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired StudentRepository studentRepository;

    @Test
    void saveMethod(){
        Student student = new Student();
        student.setFirstName("Tran");
        student.setLastName("Nguyen");
        student.setEmail("tranntn269@gmail.com");

        studentRepository.save(student);
    }

    @Test
    void updateUsingSaveMethod(){
        Long id = 1L;
        Student student = studentRepository.findById(id).get();

        student.setEmail("ntntran@gmail.com");
        studentRepository.save(student);
    }

    @Test
    void saveAllMethod(){
        Student student = new Student();
        student.setFirstName("Nam Phuong");
        student.setLastName("Tran");
        student.setEmail("nampt@gmail.com");

        Student student1 = new Student();
        student1.setFirstName("Tung");
        student1.setLastName("Bui");
        student1.setEmail("tungbui98@gmail.com");

        studentRepository.saveAll(List.of(student, student1));
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Student student = studentRepository.findById(id).get();
        System.out.println(student.toString());
    }

    @Test
    void findAllMethod(){
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void deleteByIdMethod(){
        studentRepository.deleteById(1L);
    }

    @Test
    void deleteMethod(){
        Long id = 3L;
        Student student = studentRepository.findById(id).get();

        studentRepository.delete(student);
    }

    @Test
    void deleteAllMethod(){
        Student student1 = studentRepository.findById(1L).get();
        Student student2 = studentRepository.findById(2L).get();

        studentRepository.deleteAll(List.of(student1, student2));
    }

    @Test
    void countMethod(){
        long countStudent = studentRepository.count();
        System.out.println(countStudent);
    }

    @Test
    void existByIdMethod(){
        Long id = 2L;
        boolean isExist = studentRepository.existsById(id);
        System.out.println(isExist);
    }



}