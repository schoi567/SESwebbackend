package com.seswebbackend.seswebbackend.resource;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.seswebbackend.seswebbackend.entity.*;
import com.seswebbackend.seswebbackend.repository.*;
 

 

@CrossOrigin(origins = "*")

@RestController
public class applicantsresource {
	@Autowired
	adminrepository adminrepository; 
 
	@Autowired
	applicantsrepository applicantsrepository; 
	
	@Autowired
	applicants applicants; 
	
	@Autowired
	admin admin;
	 
	  
		@GetMapping("/allapplicants")
		public List<applicants> FindAll(){
			return applicantsrepository.findAll();
		} 
	 

		@GetMapping("/admin")
		public List<admin> FindAdminAccounts(){
			return adminrepository.findAll();
		} 
		
		@GetMapping("/admin/{username}")
		public admin findbyadminid(@PathVariable String username){
			return adminrepository.findByAdminid(username);
		} 
		
		 
	 
		@PostMapping("/applicants")
		public ResponseEntity<applicants> createApplicant(
		    @RequestParam("firstname") String firstname,
		    @RequestParam("lastname") String lastname,
		    @RequestParam("email") String email,
		    @RequestParam("department") String department,
		    @RequestParam("resume") String resume
		) {
		    applicants applicant1 = new applicants(); 
		    applicant1.setFirstname(firstname);
		    applicant1.setLastname(lastname);
		    applicant1.setEmail(email);
		    applicant1.setDepartments(department);
		    applicant1.setResume(resume);

		    applicantsrepository.save(applicant1); 
		    
		    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(applicant1.getId()).toUri();
		    
		    return ResponseEntity.created(location).build();
		}
	   
		
		
}

	 
