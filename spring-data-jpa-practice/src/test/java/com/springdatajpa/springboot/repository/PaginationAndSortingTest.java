package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired StudentRepository studentRepository;

    @Test
    void paginationMethod(){
        int pageNo = 0;
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Student> page = studentRepository.findAll(pageable);

        List<Student> students = page.getContent();
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void sortingMethod(){
        String sortByDate = "dateCreated";
        String sortByEmail = "email";
        String sortDir = "desc";

        Sort sortDate = sortByDate.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDate).ascending() : Sort.by(sortByDate).descending();
        Sort sortEmail = sortByEmail.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByEmail).ascending() : Sort.by(sortByEmail).descending();

        Sort groupSortBy = sortDate.and(sortEmail);

        List<Student> students = studentRepository.findAll(groupSortBy);
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });
    }

    @Test
    void paginationAndSortingTogetherMethod(){
        String sortBy = "email";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        int pageNo = 0;
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        students.forEach(student -> {
            System.out.println(student.getEmail());
        });

        System.out.println("totalElements " + page.getTotalElements());
    }
}


