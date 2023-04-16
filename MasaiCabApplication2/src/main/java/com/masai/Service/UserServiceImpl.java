package com.masai.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.BookingDao;
import com.masai.repository.CabDao;
import com.masai.repository.DriverDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
		
	
	@Autowired
	private CabDao cabDao;
	
	
	@Autowired
	private DriverDao driverDao;
	
	@Autowired 
	private BookingDao bookingDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User registorUser(User user) throws UserException {
		User newUser=null;
		newUser=userDao.findByEmail(user.getEmail());
		if(newUser!=null) {
			throw new UserException("User Is Alrady Present By Given Email");
		}
		else {
			newUser=userDao.save(user);
			}
		return newUser;
	}

	@Override
	public User getUser(String email) throws UserException {
		User user=null;
		
		 user=userDao.findByEmail(email);
		 
		 if(user==null) {
			 throw new UserException("User Is Not Present By Given Id");
		 }
		
		return user;
	}

	@Override
	public User updateUser(User user) throws UserException {
		User newUser=null;
		 User user3=userDao.findByEmail(user.getEmail());
		 
		 
		 if(user3==null) {
			
			 throw new UserException("User Is Not Present By Given Id");
		 
		 }
		 else {
		
			 newUser=userDao.save(user);
		  
		 }
		
		return newUser;
	}

	
}
