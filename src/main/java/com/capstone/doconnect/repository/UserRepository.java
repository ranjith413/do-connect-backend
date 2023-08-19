package com.capstone.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.doconnect.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUemail(String email);

	User findByUpassword(String upassword);
}
