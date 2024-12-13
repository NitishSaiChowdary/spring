package com.dl.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dl.model.BatchTiming;
import com.dl.model.Courses;
import com.dl.model.LeadModel;
import com.dl.model.LeadStatus;
import com.dl.repository.LeadRepository;
//In service layer we write business logic
@Service
public class LeadService {
		
	@Autowired
	LeadRepository leadRepository;

	public LeadService(LeadRepository leadRepository) {
		super();
		this.leadRepository = leadRepository;
	}
    //create Method
	public LeadModel createLead(LeadModel leadModel) {
		return leadRepository.save(leadModel);
		
	}
	
	//GetAllLeads
	public List<LeadModel> getAllLeads(){
		return leadRepository.findAll();
	}
	
	//GetLeadById
	public Optional<LeadModel> getLeadById(Integer id){
		return leadRepository.findById(id);
		
	}
	
	//updateLeadById()
	public LeadModel updateLeadById(@RequestBody LeadModel leadModel) {
		return leadRepository.save(leadModel);
		
	}
	//countAllLeads()
	//count()
	public Long countAllLeads() {
		
		return leadRepository.count();
	}
	
	//deleteLeadById()
	public void deleteLeadById(Integer id) {
		
		leadRepository.deleteById(id);
	}
	
   //getCountAndOrderByStatus
	public List<LeadModel> getCountAndOrderByStatus(LeadStatus leadStatus){

		return leadRepository.findLeadByLeadStatus(leadStatus);
		
	}
	
	//getLeadByCourses
	public List<LeadModel> getLeadByCourses(Courses courses){
		return leadRepository.findLeadBycourses(courses);
		
	}
	
	//getCountAndOrderByStartingWith
	public List<LeadModel> getCountAndOrderByStartingWith(String prefix){
		return leadRepository.findBycustomerNameStartingWith(prefix);
		
	}
	
	//getLeadByUsername
	public List<LeadModel> findLeadBycustomerName(String customerName) {
		return leadRepository.findLeadBycustomerName(customerName);
		
	}
	
	//getLeadBycustomerEmail
	public List<LeadModel> findLeadBycustomerEmail(String customerEmail) {
		return leadRepository.findLeadBycustomerEmail(customerEmail);
		
	}
	
	//getLeadBycustomerFeequoted
	public LeadModel findLeadBycustomerFeequoted(Double customerFeequoted) {
		return leadRepository.findLeadBycustomerFeequoted(customerFeequoted);
		
	}
	
	//getCountAndOrderByBatch
	public List<LeadModel> getCountAndOrderByBatch(BatchTiming batchTiming){

		return leadRepository.findLeadByBatchTiming(batchTiming);
		
	}
	
	//GetLeadByDate
	public List<LeadModel> getLeadByDate(Date data){
		return leadRepository.findLeadBycustomerData(data);
		
	}
	
//
//	public List<LeadModel> sortBylead(String field){
//		return leadRepository.findAll(Sort.by(Sort.Direction.ASC,field));
//		
//	}
//	
//	
//	public Page<LeadModel> getLeadByPagination(int offset,int pageSize){
//		return leadRepository.findAll(PageRequest.of(offset, pageSize));
//		
//	}
//	
	
	public Page<LeadModel> getLeadByPaginationAndSort(String field,int offset,int pageSize){
		return leadRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
		
	}
	
	
}
