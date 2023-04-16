package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	@NotNull(message = "Can't set as Null")
	private LocalDate reservationDateAndTime;
	
	@NotNull(message = "Can't set as Null")
	private String source;
	
	@NotNull(message = "Can't set as Null")
	private String destination;
	
	
	@ManyToOne
	private Cab cab;
	
	
	@ManyToOne
	private User user;
	
	
}
