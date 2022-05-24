package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Course;
import com.springdatajpa.springboot.entity.Student;
import com.springdatajpa.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUndirectionalTest {
    @Autowired
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Test
    void saveStudent(){
        Student student = new Student();
        student.setFirstName("Tran");
        student.setLastName("Nguyen");
        student.setEmail("tranntn269@gmail.com");

        Teacher teacher = new Teacher();
        teacher.setFirstName("Tung");
        teacher.setLastName("Bui");
        teacher.setEmail("tungbui@gmail.com");

        Course course1 = new Course();
        course1.setTitle("Math");
        course1.setTeacher(teacher);
        teacher.getCourse().add(course1);

        Course course2 = new Course();
        course2.setTitle("Music");
        course2.setTeacher(teacher);
        teacher.getCourse().add(course2);

        student.getCourses().add(course1);
        student.getCourses().add(course2);

        teacherRepository.save(teacher);
        studentRepository.save(student);
    }
}
