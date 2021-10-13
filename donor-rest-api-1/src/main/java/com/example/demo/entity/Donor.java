package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="donor")
public class Donor {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name = "name")
	String name;
	
	
	@Column(name="bloodgroup")
	String bloodGroup;
	
	
	@Column(name = "location")
	String location;
	
	@Column(name= "phonenumber")
	long phoneNumber;
	
	
	
	@Column(name="previousdonation")
	LocalDate previousDonation;
	
	@Column(name ="pincode")
	int pinCode;

}
