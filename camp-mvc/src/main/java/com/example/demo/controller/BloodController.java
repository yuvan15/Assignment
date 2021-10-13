package com.example.demo.controller;

import javax.validation.Valid;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Camp;
import com.example.demo.entity.Donor;

@Controller
public class BloodController {
	
	
	@Autowired
	private Donor object;
	
	@Autowired
	private Camp object2;
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
    private RestTemplate template;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String init(Model model) {
		
		//model
		model.addAttribute("majHeading","Blood Bank");
		//view
		return "index";
		
	}
	
//********************************************Donor's Detail********************************************//
	
	/*
	 * 
	 * Adding Donor's to the table
	 * 
	 */
	@GetMapping(path="/addDonor")
	public String sendDonorDetails(Model model) {
	model.addAttribute("donor",object);
	return "addDonor";
	}
	
	
	@PostMapping(path="/addDonor")
	public String submitDonorDetails(@Valid @ModelAttribute("donor") Donor donor,BindingResult result) {
		
		String nextStep = "success";



	if(result.hasErrors()) {
		nextStep = "addDonor";
	}
	else {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
		template.postForObject("http://localhost:2020/api/v1/donor", requestBody, Donor.class);
	}
		return nextStep;
	}
	
	
	/*
	 * 
	 * Display all Donor's
	 * 
	 * 
	 */
	@GetMapping(path = "/getAllDonors")
	public String findAll(Model model) {
		Donor[] resp =template.getForObject("http://localhost:2020/api/v1/donor",
		Donor[].class);
		model.addAttribute("donors",resp);
		return "displayDonors";
	}
	
	
	/*
	 *
	 * 
	 * Get by required blood group
	 * 
	 * 
	 */

	@GetMapping(path = "/getBloodGroup")
	public String findByBloodGroup(Model model,String search) {
	Donor[] resp =template.getForObject("http://localhost:2020/api/v1/donor/"+search,
	Donor[].class);
	if(resp.length>0) {
		model.addAttribute("donors",resp);
		return "displayDonors";
	}else {
		return "dataNotAvailable";
	}
	}
	/*
	 * 
	 * Get by required location
	 * 
	 */
	@GetMapping(path = "/getLocation")
	public String findByLocation(Model model,String location) {
		Donor[] resp =template.getForObject("http://localhost:2020/api/v1/donor/loc/"+location,
		Donor[].class);
		if(resp.length>0) {
		model.addAttribute("donors",resp);
		return "displayDonors";
	}else {
		return "dataNotAvailable";
		}
	}
	
	/*
	 * 
	 * unregister donor's
	 * 
	 */
	@GetMapping(path="/unregister")
	public String removeDonor(Model model,int value)
	{
		template.delete("http://localhost:2020/api/v1/donor/"+value,Donor[].class);
		return "delete";
	}
	
	/*
	 * 
	 * 
	 * update donor's details
	 * 
	 * 
	 */
	@GetMapping(path="/updatedonor")
	public String updateDonor(Model model,int donorId, String donorName, String bloodGroup, String donorLocation, long num, String preDate,int pinCode)
	{
		template.put("http://localhost:2020/api/v1/donor/"+donorId+"/"+donorName+"/"+bloodGroup+"/"+donorLocation+"/"+num+"/"+preDate+"/"+pinCode,Donor[].class);
		return "update";
	} 

	
//*********************************************Camp Details*********************************************//
	
	

	/*
	 * 
	 * //Adding donation camp//
	 * 
	 */
	
	
	@GetMapping(path="/addCamp")
	public String sendCampDetails(Model model) {
	model.addAttribute("camp",object2);
	 	return "addCamp";
	}
	
	
	@PostMapping(path="/addCamp")
	public String submitCampDetails(@Valid @ModelAttribute("camp")Camp camp,BindingResult result) {
		
		String nextStep = "success";

 

	if(result.hasErrors()) {
		nextStep = "addCamp";
	}
	else {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Camp> requestBody = new HttpEntity<>(camp,headers);
		template.postForObject("http://localhost:2025/api/v1/camp", requestBody, Camp.class);
	}
		return nextStep;
	}
	
	/*
	 * 
	 * 
	 * get all camp details
	 * 
	 * 
	 */
	@GetMapping(path = "/getAllCamp")
	public String findAllCamp(Model model) {
		Camp[] resp =template.getForObject("http://localhost:2025/api/v1/camp",
		Camp[].class);
		model.addAttribute("camps",resp);
		return "displayCamps";
	}
	
	/*
	 * 
	 * 
	 * find by location 
	 * 
	 * 
	 */
	@GetMapping(path = "/getCampLocation")
	public String findByCampLocation(Model model,String location) {
		Camp[] resp =template.getForObject("http://localhost:2025/api/v1/camp/loc/"+location,
		Camp[].class);
		if(resp.length>0) {
			model.addAttribute("camps",resp);
			return "displayCamps";
		}
		else {
			return "dataNotAvailable";
		}
		
	}
	
	/*
	 * 
	 * 
	 * update camp details
	 * 
	 * 
	 */
	@GetMapping(path="/updateCamp")
	public String updateCamp(Model model,int id, int pin,String location,String date,long num)
	{ 
		template.put("http://localhost:2025/api/v1/camp/"+id+"/"+date+"/"+num+"/"+location+"/"+pin,Camp[].class);
		return "update";
	}
	
	/*
	 * 
	 * 
	 * Delete camp
	 * 
	 * 
	 */
	
	@GetMapping(path="/unregisterCamp")
	public String removeCamp(Model model,int value)
	{
		template.delete("http://localhost:2025/api/v1/camp/"+value,Camp[].class);
		return "delete";
	}

	

}
