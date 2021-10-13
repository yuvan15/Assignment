package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Camp;

import com.example.demo.service.CampService;

import net.bytebuddy.asm.Advice.Local;


@RestController
@RequestMapping(path="api/v1/camp")
public class CampController {
	
	private CampService service;
	
	@Autowired
	public void setService(CampService service) {
		
		this.service = service;
	} 
	
	/*
	 * 
	 * view all camp
	 * 
	 */
	@GetMapping 
	
	public List<Camp> findAll(){
		
		return this.service.findAll();
	}
	
	/*
	 * 
	 * adding new camp
	 * 
	 */
	
	@PostMapping 
	public ResponseEntity<Camp> add(@RequestBody Camp entity) {
		Camp addedEntity = this.service.addCamp(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	/*
	 * 
	 * find by locality
	 * 
	 * 
	 */
	@GetMapping(path="/loc/{location}")
	public List<Camp> fidnByCampLocation(@PathVariable("location")String location)
	{
	return this.service.findByLocation(location);
	}
	
	/*
	 * 
	 * Delete by id
	 * 
	 */
	@DeleteMapping(path ="/{campId}")
	public ResponseEntity<String> removeCamp(@PathVariable("campId") int campId) {
		int count = this.service.remove(campId);
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = "Record Not Found";
		
		if(count==1) {
			
			status = HttpStatus.OK;
			message = "One Record Deleted";	
		}
			
			return ResponseEntity.status(status).body(message);
			
	}
	
	/*
	 * 
	 * update details
	 * 
	 * 
	 */
///{nameToUpdate} nameToUpdate, @PathVariable("updName") String nameToUpdate
	@PutMapping(path="/{campId}/{dateToUpdate}/{numberToUpdate}/{locationToUpdate}/{pinToUpdate}")
	public ResponseEntity<String> updateCamp(@PathVariable("campId")int campId,@PathVariable("dateToUpdate") String dateToUpdate,@PathVariable("numberToUpdate") long numberToUpdate, @PathVariable("locationToUpdate") String locationToUpdate,@PathVariable("pinToUpdate") int pinToUpdate)
	{
		LocalDate updatedDate=LocalDate.parse(dateToUpdate);
	int count=this.service.updateCamp(campId, updatedDate,numberToUpdate,locationToUpdate,pinToUpdate);
	return ResponseEntity.ok().body(count+":+Records Updated");
	}
	 

}
