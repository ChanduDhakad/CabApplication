package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.model.CustomerLogin;
import com.masai.model.User;
import com.masai.repository.UserDao;
@Service
public class CustomerLoginUser implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	
  @Override
	public UserDetails loadUserByUsername(String email) throws  UsernameNotFoundException{
		// TODO Auto-generated method stub
		User u=null;
		
		 u=userDao.findByEmail(email);
		
		if(u==null) {
			u=userDao.findByMobileNumber(email);
		}
		if(u==null) {
			throw new UsernameNotFoundException("No user Exist With Email "+email);
		}
		return new CustomerLogin(u);
	}

}
