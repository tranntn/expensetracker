package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.User;
import com.springdatajpa.springboot.entity.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class OneToOneBidirectionalMapping {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Test
    void saveUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setPhoneNumber("0392799990");
        userProfile.setAddress("28 To ky");
        userProfile.setGender(true);
        userProfile.setBirthOfDate(new Date(1998, 9, 26));

        User user = new User();
        user.setEmail("ntntran@tma.com.vn");
        user.setName("Tran Nguyen");

        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        userProfileRepository.save(userProfile);
    }

    @Test
    void updateUserProfileMethod() {
        UserProfile userProfile = userProfileRepository.findById(1L).get();

        userProfile.setAddress("TMA Solutions");

        userProfile.getUser().setEmail("tranntn269@gmail.com");
        userProfileRepository.save(userProfile);
    }

    @Test
    void deleteUserProfileMethod() {
        userProfileRepository.deleteById(1L);
    }
}
