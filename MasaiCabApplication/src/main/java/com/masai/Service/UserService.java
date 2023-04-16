package com.masai.Service;

import com.masai.Exception.UserException;
import com.masai.model.User;

public interface UserService {

	public User registorUser(User user)throws UserException;
	public User getUser(String email)throws UserException;
	public User updateUser(User user)throws UserException;
	

}
