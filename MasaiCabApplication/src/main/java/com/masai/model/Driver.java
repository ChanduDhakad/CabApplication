package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Driver {

	    @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		private Integer  driverId;

		@NotNull(message = "first name  cannot set as null")
		@NotEmpty(message = "first name cannot set as empty")
		@NotBlank(message = "first name cannot set as blank")
		@javax.validation.constraints.Pattern(regexp = "[A-Za-z]")
	    private String firstName;
		
		
		
		@NotNull(message = "last name  cannot set as null")
		@NotEmpty(message = "last name cannot set as empty")
		@NotBlank(message = "last name cannot set as blank")
		@Pattern(regexp = "[A-Za-z]")
		private String lastName;

		
		@NotNull(message = "Email  cannot set as null")
		@NotEmpty(message = "Email cannot set as empty")
		@NotBlank(message = "Email cannot set as blank")
		@Email(message = "email format is incorrect")
		@Column(unique = true)
		private String email;
		
		@NotNull(message = "mobileNumber cannot set as null")
		@Pattern(regexp = "^[789]\\d{9}$")
		@Column(unique = true)
		private String mobileNumber;
		
	    @NotNull(message = "password cannot set as null")
		@NotEmpty(message = "password cannot set as empty")
		@NotBlank(message = "password cannot set as blank")
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{6, 12}$")
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    private String password;
		
	    
	    @Size(min = 2,max = 2 ,message = "array size must be 2")
		private Integer[] currentPosition;
       
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    private Cab cab;

}
