package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Course;
import com.springdatajpa.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class OneToManyUndirectionalTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void createTeacherMethod(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Tran");
        teacher.setLastName("Nguyen");
        teacher.setEmail("tranntn269@gmail.com");

        Course course1 = new Course();
        course1.setTitle("Math");
        teacher.getCourse().add(course1);

        Course course2 = new Course();
        course2.setTitle("Music");
        teacher.getCourse().add(course2);

        teacherRepository.save(teacher);
    }

    @Test
    void updateTeacherMethod(){
        Teacher teacher = teacherRepository.findById(1L).get();
        teacher.setEmail("ntntran@tma.com.vn");

        for (Course course: teacher.getCourse() ) {
            course.setTitle(course.getTitle()+ " new");
        }

        teacherRepository.save(teacher);
    }

    @Test
    void deleteTeacherMethod(){
        teacherRepository.deleteById(1L);
    }
}
