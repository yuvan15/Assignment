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

public class Camp {
	
	
	int campId;
	
	@NotEmpty(message="Enter Camp Name")
	String name;	
	
	@NotNull(message="Enter Camp date")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate campDate;
	
	long phoneNumber;
	
	@NotNull(message="Enter Camp location")
	String location;
	
	int pinCode;
	
}
