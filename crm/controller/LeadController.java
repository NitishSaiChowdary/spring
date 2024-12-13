package com.dl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.model.BatchTiming;
import com.dl.model.Courses;
import com.dl.model.LeadModel;
import com.dl.model.LeadStatus;
import com.dl.service.LeadService;

@RestController
@RequestMapping("/api")
public class LeadController {
	 
	@Autowired
	LeadService leadService;

	public LeadController(LeadService leadService) {
		super();
		this.leadService = leadService;
	}
	
	@PostMapping("/createLead")
	public LeadModel createLead(@RequestBody LeadModel leadModel) {
		return leadService.createLead(leadModel);
		
	}
	
	@GetMapping("/getAllLeads")
	public List<LeadModel> getAllLeads(){
		return leadService.getAllLeads();
		
	}
	//GetLeadById
	@GetMapping("/getLeadById/{id}")
	public Optional<LeadModel> getLeadById(@PathVariable("id") Integer id){
		return leadService.getLeadById(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLeadById(@PathVariable Integer id) {
	    leadService.deleteLeadById(id);
	}
	
	//countAllLeads
    @GetMapping("/countLeads")
    public long countAllLeads() {
        return leadService.countAllLeads();
    }
    
    //updatelead 
	@PutMapping("/updateLead")
	public LeadModel updateLead(@RequestBody LeadModel leadModel) {
		
		return leadService.updateLeadById(leadModel);
		
	}
    
	@GetMapping("/{status}/leadstatus")
	public ResponseEntity<Map<String,Object>> getCountAndOrderByStatus(@PathVariable("status") LeadStatus leadStatus){
		List<LeadModel> orders =leadService.getCountAndOrderByStatus(leadStatus);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/{courses}/courses")
	public ResponseEntity<Map<String,Object>> getCountAndOrderByStatus(@PathVariable("courses") Courses courses){
		List<LeadModel> orders =leadService.getLeadByCourses(courses);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	
	
	
	@GetMapping("/customerNameStartingWith/{prefix}")
	public ResponseEntity<Map<String,Object>> findByCustomerNameStartingWith(@PathVariable("prefix") String prefix){
		List<LeadModel> orders =leadService.getCountAndOrderByStartingWith(prefix);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	
//	@GetMapping("/customerNameStartingWith/{prefix}")
//	public ResponseEntity<List<LeadModel>> findByCustomerNameStartingWith(@PathVariable("prefix") String prefix) {
//	    List<LeadModel> leads = leadService.getCountAndOrderByStartingWith(prefix);
//	    
//	    if (leads != null && !leads.isEmpty()) {
//	        return ResponseEntity.ok(leads);
//	    } else {
//	        return ResponseEntity.notFound().build();
//	    }
//	}
 
	
	@GetMapping("/username/{customerName}")
//    public ResponseEntity<LeadModel> findLeadBycustomerName(@PathVariable("customerName") String customerName) {
//        LeadModel lead = leadService.findLeadBycustomerName(customerName);
//        if (lead != null) {
//            return ResponseEntity.ok(lead);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//	}	
	public ResponseEntity<Map<String,Object>> findLeadBycustomerName(@PathVariable("customerName") String customerName){
		List<LeadModel> orders =leadService.findLeadBycustomerName(customerName);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/customerEmail/{customerEmail}")
//    public ResponseEntity<LeadModel> findLeadBycustomerEmail(@PathVariable("customerEmail") String customerEmail) {
//        LeadModel lead1 = leadService.findLeadBycustomerEmail(customerEmail);
//        if (lead1 != null) {
//            return ResponseEntity.ok(lead1);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//	}
	public ResponseEntity<Map<String,Object>> findLeadBycustomerEmail(@PathVariable("customerEmail") String customerEmail){
		List<LeadModel> orders =leadService.findLeadBycustomerEmail(customerEmail);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/customerFeequoted/{customerFeequoted}")
	public ResponseEntity<LeadModel> findLeadBycustomerFeequoted(@PathVariable("customerFeequoted") Double customerFeequoted) {
        LeadModel lead21 = leadService.findLeadBycustomerFeequoted(customerFeequoted);
        if (lead21 != null) {
            return ResponseEntity.ok(lead21);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/{batch}/batchTiming")
	public ResponseEntity<Map<String,Object>> getCountAndOrderByBatch(@PathVariable("batch") BatchTiming batchTiming){
		List<LeadModel> orders =leadService.getCountAndOrderByBatch(batchTiming);
		int count = orders.size();
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		response.put("count", count);//your record count
		response.put("orders", orders);//your record detelis
		return ResponseEntity.ok(response);
		
	}
	

//    @GetMapping("/sort/{field}")
//    public List<LeadModel> sortBylead(@PathVariable("field") String field) {
//        return leadService.sortBylead(field);
//    }
//    @GetMapping("/pagination/{offSet}/{pageSize}")
//    public Page<LeadModel> getLeadByPagination(@PathVariable int offSet,@PathVariable int pageSize){
//		return leadService.getLeadByPagination(offSet, pageSize);
//    	
//    }

    @GetMapping("/PaginationAndSorting/{offSet}/{pageSize}/{field}")
    public Page<LeadModel> getLeadByPaginationAndSort(@PathVariable int offSet,@PathVariable int pageSize,@PathVariable("field") String field){
		return leadService.getLeadByPaginationAndSort(field, offSet, pageSize);
    	
    }
    
    @GetMapping("/getLeadsByDate")
    public ResponseEntity<List<LeadModel>> getLeadsByDate(
        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date leadDate) {
        List<LeadModel> leads = leadService.getLeadByDate(leadDate);
        return ResponseEntity.ok(leads);
    }
 
}
