package com.dl.repository;

import java.util.Date;
import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.model.BatchTiming;
import com.dl.model.Courses;
import com.dl.model.LeadModel;
import com.dl.model.LeadStatus;

@Repository
public interface LeadRepository extends JpaRepository<LeadModel, Integer> {
	
	List<LeadModel> findLeadByLeadStatus(LeadStatus leadStatus);
	
	List<LeadModel>  findBycustomerNameStartingWith(String prefix);
	
	List<LeadModel> findLeadByBatchTiming(BatchTiming batchTiming);
	
	List<LeadModel> findLeadBycustomerData(Date data);	

	List<LeadModel> findLeadBycustomerName(String customerName);
	
	List<LeadModel> findLeadBycustomerEmail(String customerEmail);

	LeadModel findLeadBycustomerFeequoted(Double customerFeequoted);
	
	List<LeadModel> findLeadBycourses(Courses courses);
  
}
