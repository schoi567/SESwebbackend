package com.seswebbackend.seswebbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.io.File;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.stereotype.Controller;
 

@Entity
@Table
@Controller
 
public class applicants {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	@Column
	private String email;
    private String route;
    private String firstname;
    private String lastname;
    private String Departments; 
    @Temporal(TemporalType.TIMESTAMP) // This will store both date and time. Use TemporalType.DATE for just the date.
    private Date Date; // Use java.util.Date or java.time.LocalDateTime
    private String status; 
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] resume;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartments() {
		return Departments;
	}
	public void setDepartments(String departments) {
		Departments = departments;
	}
	
	
	
	
	
 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	 
 
	
	
	


	
	
	public applicants(Long id, String email, String route, String firstname, String lastname, String departments,
			java.util.Date date, String status, byte[] resume) {
		super();
		this.id = id;
		this.email = email;
		this.route = route;
		this.firstname = firstname;
		this.lastname = lastname;
		Departments = departments;
		Date = date;
		this.status = status;
		this.resume = resume;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public applicants() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
    
    
     
	
}
