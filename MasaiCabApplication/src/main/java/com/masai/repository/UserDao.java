package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

        
	public User findByMobileNumber(String mobileNumber);
	public User findByEmail(String email);

}
