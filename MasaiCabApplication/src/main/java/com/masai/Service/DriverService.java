package com.masai.Service;

import java.util.List;

import com.masai.Exception.CabException;
import com.masai.Exception.DriverException;
import com.masai.model.Booking;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;

public interface DriverService {

	
	public Driver addDriver(Driver driver,Cab cab) throws DriverException ,CabException;

	public Booking getDriverById(Integer id, Integer a,Integer b,String destination,String source)throws DriverException;
	public List<Driver> getDriver()throws DriverException;
	
	
 
}
