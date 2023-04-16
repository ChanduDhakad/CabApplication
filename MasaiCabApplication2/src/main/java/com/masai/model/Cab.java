package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Cab {

	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cabId;
	
    @NotNull(message = "licence Plate cannot set as null")
    @Column(unique = true)
    private String licencePlate;
 
    @NotNull(message = "Cab Type cannot set as null")
	private String  cabType;
	
    
   @OneToOne()
   private Driver driver;
   
	 
      
  	

}
