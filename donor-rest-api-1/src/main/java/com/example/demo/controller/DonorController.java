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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Donor;
import com.example.demo.service.DonorService;


@RestController
@RequestMapping(path="api/v1/donor")
public class DonorController {
	
	private DonorService service;
	
	@Autowired
	public void setService(DonorService service) {
		
		this.service = service;
	} 
	
	/*
	 * view all donor's
	 */
	@GetMapping 
	
	public List<Donor> findAll(){
		
		return this.service.findAll();
	}
	
	/*
	 * adding new donor's
	 */
	
	@PostMapping 
	public ResponseEntity<Donor> add(@RequestBody Donor entity) {
		Donor addedEntity = this.service.addDonor(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	/*
	 * blood group searching
	 */

	@GetMapping(path="/{bloodGroup}")
	public List<Donor> findByBloodGroup(@PathVariable("bloodGroup")String bloodGroup)
	{
		return this.service.findByBloodGroup(bloodGroup);
	}
	
	/*
	 * 
	 */
	@GetMapping(path="/loc/{location}")
	public List<Donor> findByLocation(@PathVariable("location")String location)
	{
		return this.service.findByLocation(location);
	}
	
	@DeleteMapping(path ="/{id}")
	public ResponseEntity<String> removeDonor(@PathVariable("id") int id) {
		int count = this.service.remove(id);
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = "Record Not Found";
		
		if(count==1) {
			
			status = HttpStatus.OK;
			message = "One Record Deleted";	
		}
			
			return ResponseEntity.status(status).body(message);
		
			
	}
	
	@PutMapping(path="/{donorId}/{nameToUpdate}/{groupToUpdate}/{locationToUpdate}/{numToUpdate}/{dateToUpdate}/{pinToUpdate}")
	public ResponseEntity<String> updateDonor(@PathVariable("donorId")int donorId, @PathVariable("nameToUpdate") String nameToUpdate, @PathVariable("groupToUpdate") String groupToUpdate, @PathVariable("locationToUpdate") String locationToUpdate,@PathVariable("numToUpdate") long numToUpdate, @PathVariable("dateToUpdate") String dateToUpdate, @PathVariable("pinToUpdate") int pinToUpdate) 
	{
		LocalDate upd=LocalDate.parse(dateToUpdate);
	int count=this.service.updateDonor(donorId, nameToUpdate, groupToUpdate,locationToUpdate,numToUpdate,upd,pinToUpdate);
	return ResponseEntity.ok().body(count+":+Records Updated");
	}
	
	

}
