package com.example.demo.ifaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Camp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface CampRepo extends JpaRepository<Camp, Integer> {

	List<Camp> findByLocation(String loc);
	
	//query for update statements

	@Query(nativeQuery = true,value = "update camp_details set campDate=:campdate,phoneNumber=:phonenumber, location=:location,pinCode=:pincode where campId=:number")
	@Modifying
	@Transactional
	public int updateCamp(@Param("number") int campId,@Param("campdate") LocalDate dateToUpdate,   
			@Param("phonenumber") long numberToUpdate, @Param("location") String locationToUpdate, @Param("pincode") int pinToUpdate);

}
//name=:Updname,//,@Param("updName") String nameToUpdate