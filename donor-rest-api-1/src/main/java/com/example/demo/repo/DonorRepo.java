package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, Integer> {

	public List<Donor> findByBloodGroup(String key);
	public List<Donor> findByLocation(String loc);
	public boolean existsById(int id);
	public void deleteById(int id);
	
	
	@Query(nativeQuery = true,value = "update donor set name=:name, bloodGroup=:group, location=:location, phoneNumber=:phn, previousDonation=:predate, pinCode=:pin where id=:number")
	@Modifying
	@Transactional
	public int updateDonor(@Param("number") int donorId, @Param("name") String nameToUpdate,  @Param("group") String groupToUpdate, @Param("location") String locationToUpdate, 
			@Param("phn") long numToUpdate, @Param("predate") LocalDate dateToUpdate, @Param("pin") int pinToUpdate);
	
	
	
	
	

}
