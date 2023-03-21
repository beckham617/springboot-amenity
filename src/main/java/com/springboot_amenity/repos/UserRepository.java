package com.springboot_amenity.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_amenity.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUserName(String username);
}
