package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.entity.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class OneToOneUndirectionalMappingTest {
    @Autowired UserRepository userRepository;

    @Test
    void createNewStudentMethod(){
        User user = new User();
        user.setName("Tran Nguyen");
        user.setEmail("tranntn269@gmail.com");

        UserProfile userProfile= new UserProfile();
        userProfile.setPhoneNumber("0392799990");
        userProfile.setAddress("28 To Ky");
        userProfile.setGender(true);
        userProfile.setBirthOfDate(new Date(1998, 9, 26));

        user.setUserProfile(userProfile);

        userRepository.save(user);
    }

    @Test
    void updateUserMethod(){
       User user = userRepository.findById(1L).get();
       user.setEmail("ntntran@tma.com.vn");

       user.getUserProfile().setAddress("TMA Solutions");

       userRepository.save(user);
    }

    @Test
    void deleteUserMethod(){
        userRepository.deleteById(1L);
    }
}
