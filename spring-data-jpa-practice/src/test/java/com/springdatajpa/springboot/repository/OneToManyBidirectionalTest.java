package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Course;
import com.springdatajpa.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyBidirectionalTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void createTeacherMethod(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Tung");
        teacher.setLastName("Bui");
        teacher.setEmail("tungbui@gmail.com");

        Course course1 = new Course();
        course1.setTitle("Chemistry");
        course1.setTeacher(teacher);
        teacher.getCourse().add(course1);

        Course course2 = new Course();
        course2.setTitle("Literature");
        course2.setTeacher(teacher);
        teacher.getCourse().add(course2);

        teacherRepository.save(teacher);
    }

    @Test
    void deleteTeacherMethod(){
        Teacher teacher = teacherRepository.findById(1L).get();
        teacherRepository.delete(teacher);
    }
}
