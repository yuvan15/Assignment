package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="camp_details")
public class Camp {
	
	@Id
	@Column(name="campid")
	int campId;
	
	@Column(name = "name")
	String name;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="campdate")
	LocalDate campDate;
	
	@Column(name= "phonenumber")
	long phoneNumber;
	
	
	@Column(name = "location")
	String location;

	
	@Column(name ="pincode")
	int pinCode;
	
}
