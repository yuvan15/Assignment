package com.example.demo.entity;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Component
@FieldDefaults(level=AccessLevel.PRIVATE)

public class Donor {
	
	@Min(value=100, message="ID must be equal or greater than 100")
	@Max(value=1000, message="ID must be equal or less than 1000")
	int id;
	
	@NotEmpty(message="Enter Donor Name")
	String name;
	
	@NotEmpty(message="Enter Donor Blood Group")
	String bloodGroup;
	
	long phoneNumber;
	
	@NotEmpty(message="Enter Donor Location")
	String location;
	
	@NotNull(message="Enter Donor Last Donation date")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate previousDonation;
	
	int pinCode;

}
