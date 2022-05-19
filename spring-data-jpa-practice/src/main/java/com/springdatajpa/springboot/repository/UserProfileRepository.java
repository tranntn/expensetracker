package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
