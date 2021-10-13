package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.repo.DonorRepo;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepo repo;
	
	
	/*
	 * Donor list
	 */
	public List<Donor> findAll(){
		
		return this.repo.findAll();
	}
	
	/*
	 * adding new Donor
	 */
	public Donor addDonor(Donor entity) {
		
		return this.repo.save(entity);
		
	}
	
	/*
	 * same blood group
	 */
	public List<Donor> findByBloodGroup(String key){
		
		return this.repo.findByBloodGroup(key);
	}
	
	/*
	 * same location
	 */
	public List<Donor> findByLocation(String loc){
		
		return this.repo.findByLocation(loc);
	}
	
	/*
	 * delete 
	 */
	public int remove(int id) {
		
		int rowDeleted = 0;
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
			rowDeleted = 1;
		}
		return rowDeleted;
	}
	
	/*
	 * update
	 */
	public int updateDonor(int donorId,String nameToUpdate,String groupToUpdate, String locationToUpdate, long numToUpdate, LocalDate dateToUpdate, int pinToUpdate){
		return this.repo.updateDonor(donorId,nameToUpdate, groupToUpdate, locationToUpdate, numToUpdate, dateToUpdate, pinToUpdate);
	} 
}
 


