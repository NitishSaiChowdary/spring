package com.dl.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

//This annotation generates a no-argument constructor (i.e., a default constructor) for your class.
//This is useful when you need to instantiate an object without passing any arguments
@NoArgsConstructor

//This annotation generates a constructor with parameters for all the fields in the class. 
//It allows you to create an object and initialize all its fields in one step
@AllArgsConstructor 
@Entity
public class LeadModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerMoblieno")
	private Long customerMoblieno;
	
	@Column(name="customerEmail")
	private String customerEmail;
	
	@Column(name="customerFeequoted")
	private Double customerFeequoted;
	
	@Column(name="customerDescription")
	private String customerDescription;
	
	@Column(name="customerCc")
	private int customerCc;
	
	@Column(name="customerData")
	private Date customerData;
	
	@Column
	@Enumerated(EnumType.STRING)
	private BatchTiming batchTiming;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ClassMode classMode;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Courses courses;
	 
	@Column
	@Enumerated(EnumType.STRING)
	private LeadSource leadSource;
	
	@Column
	@Enumerated(EnumType.STRING)
	private LeadStatus leadStatus;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TechStack techStack;

		 
	

}
