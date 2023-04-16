package com.masai.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.masai.Exception.CabException;
import com.masai.Exception.DriverException;
import com.masai.model.Booking;
import com.masai.model.Cab;
import com.masai.model.CustomerLogin;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;
import com.masai.model.User;
import com.masai.repository.BookingDao;
import com.masai.repository.CabDao;
import com.masai.repository.DriverDao;
import com.masai.repository.UserDao;

public class DriverServiceImpl implements DriverService{

	

	@Autowired
	private UserDao userDao;
		
	
	@Autowired
	private CabDao cabDao;
	
	
	@Autowired
	private DriverDao driverDao;
	
	@Autowired 
	private BookingDao bookingDao;
	

	
	@Override
	public Driver addDriver(Driver driver,Cab cab) throws DriverException,CabException {
     Driver nDriver=null;
     Driver driver1=driverDao.findByEmail(driver.getEmail());
      if(driver1!=null) {
    	   throw new DriverException("Driver Is Alrady Is Registered By By Given Email");
      }
      else {
    	   Cab cab1=cabDao.findByLicencePlate(cab.getLicencePlate());
    	   if(cab1!=null) {
    		   throw new CabException("Cab Is Alrady Registered");
    	   }
    	   else {
    		    driver.setCab(cab);
    		    cab.setDriver(driver);
    		    nDriver=driverDao.save(driver);
    	   }}
     return nDriver;
	}

	@Override
	public Booking getDriverById(Integer id, Integer a, Integer b,String destination,String source) throws DriverException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomerLogin customer=(CustomerLogin)principal;
		User isUserExist=userDao.findByEmail(customer.getUsername());
		Driver isDriverExist=driverDao.findById(id).orElse(null);
		if(isDriverExist==null) {
			throw new DriverException("No driver found with id "+id);
		}
		
		
		
		Integer x= isDriverExist.getCurrentPosition()[0];
		Integer y= isDriverExist.getCurrentPosition()[1];
		Integer x2= isUserExist.getCurrentPosition()[0];
		Integer y2= isUserExist.getCurrentPosition()[1];
	
		boolean isInLimits= Math.sqrt((y2 - y) * (y2 - y) + (x2 - x) * (x2 - x))<=5;
		
		
		if(!isInLimits) {
			throw new DriverException("Driver is far away from  nearest 5 km from your position ");
		}
		Integer[] arr={a,b};
		isUserExist.setCurrentPosition(arr);
		isDriverExist.setCurrentPosition(arr);
		
		userDao.save(isUserExist);
		  
		Booking booking=new Booking();
		booking.setDestination(destination);
		booking.setCab(isDriverExist.getCab());
		booking.setReservationDateAndTime(LocalDate.now());
		booking.setSource(source);
		booking.setUser(isUserExist);
		
		isUserExist.getListOfBookings().add(booking);
		
        userDao.save(isUserExist);
       Booking booking2=bookingDao.save(booking);
		
		return booking2;
	}

	@Override
	public List<Driver> getDriver() throws DriverException {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomerLogin customer=(CustomerLogin)principal;
		User isUserExist=userDao.findByEmail(customer.getUsername());
		
		List<Driver> driverList=driverDao.findAll();
		
		if(driverList==null || driverList.size()==0) {
			throw new DriverException("No driver Available");
		}
		
		
		List<Driver>filterdList=driverList.stream().filter(s->{
			Integer x= s.getCurrentPosition()[0];
			Integer y= s.getCurrentPosition()[1];
			Integer x2= isUserExist.getCurrentPosition()[0];
			Integer y2= isUserExist.getCurrentPosition()[1];
			return Math.sqrt((y2 - y) * (y2 - y) + (x2 - x) * (x2 - x))<=5;
			 
		}).collect(Collectors.toList());
		
		if(filterdList==null || filterdList.size()==0) {
			throw new DriverException("No driver Available");
		}
		return filterdList;
		
	}


}
