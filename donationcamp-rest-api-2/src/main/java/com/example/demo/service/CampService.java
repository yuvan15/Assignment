package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Camp;

import com.example.demo.ifaces.CampRepo;

@Service
public class CampService {
	
	@Autowired
	private CampRepo repo;
	
	/*
	 * Camp list
	 */
	public List<Camp> findAll(){
		
		return this.repo.findAll();
	}
	
	/*
	 * adding new camp
	 */
	public Camp addCamp(Camp entity) {
		
		return this.repo.save(entity);
		
	}
	
	/*
	 * same location
	 */
	public List<Camp> findByLocation(String loc){
		
		return this.repo.findByLocation(loc);
	}
	
	/*
	 * delete 
	 */
	public int remove(int campId) {
		
		int rowDeleted = 0;
		if(this.repo.existsById(campId)) {
			this.repo.deleteById(campId);
			rowDeleted = 1;
		}
		return rowDeleted;
	}
	
	
	/*
	 * 
	 * update details
	 * 
	 */
	public int updateCamp(int campId,LocalDate dateToUpdate, long numberToUpdate,String locationToUpdate, int pinToUpdate){
		
		return this.repo.updateCamp(campId, dateToUpdate, numberToUpdate, locationToUpdate, pinToUpdate);
	}
//,String nameToUpdate
	//,nameToUpdate
}
