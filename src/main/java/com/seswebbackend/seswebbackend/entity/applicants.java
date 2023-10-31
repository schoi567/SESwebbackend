package com.seswebbackend.seswebbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.io.File;

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
	
	
	
 
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	 
	public applicants(Long id, String email, String route, String firstname, String lastname, String departments,
			byte[] resume) {
		super();
		this.id = id;
		this.email = email;
		this.route = route;
		this.firstname = firstname;
		this.lastname = lastname;
		Departments = departments;
		this.resume = resume;
	}
	public applicants() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
    
    
     
	
}
