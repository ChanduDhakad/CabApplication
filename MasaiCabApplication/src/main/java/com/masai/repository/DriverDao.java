package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Driver;
import com.masai.model.User;

@Repository
public interface DriverDao extends JpaRepository<Driver, Integer> {


	public Driver findByMobileNumber(String mobileNumber);
	public Driver findByEmail(String email);
}
