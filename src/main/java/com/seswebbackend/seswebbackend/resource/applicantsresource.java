package com.seswebbackend.seswebbackend.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.seswebbackend.seswebbackend.entity.*;
import com.seswebbackend.seswebbackend.repository.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;



 

@CrossOrigin(origins = {"*", "http://192.168.10.107:4200", 
		"http://192.168.10.107:4200/adminlogin"})
 

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
	 
	private static final Logger logger = LoggerFactory.getLogger(applicantsresource.class);

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
		    @RequestParam("resume") MultipartFile resumeFile
		) throws IOException {
		    applicants applicant1 = new applicants(); 
		    applicant1.setFirstname(firstname);
		    applicant1.setLastname(lastname);
		    applicant1.setEmail(email);
		    applicant1.setDepartments(department);
		    applicant1.setResume(resumeFile.getBytes());

		    applicantsrepository.save(applicant1); 
		    
		    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(applicant1.getId()).toUri();
		    System.out.println(location);	    
		    return ResponseEntity.created(location).build();
		}
	   
		/*
		@GetMapping("/downloadResume/{id}")
		public ResponseEntity<byte[]> downloadResume(@PathVariable Long id) {
		    byte[] resumeData = applicants.getResume(); 
		    

		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    headers.setContentDisposition(ContentDisposition.builder("attachment").filename("resume.pdf").build());  // assuming it's a PDF, change filename accordingly

		    return new ResponseEntity<>(resumeData, headers, HttpStatus.OK);
		}
		
		 @GetMapping("/downloadResume/{id}")
		    public ResponseEntity<byte[]> downloadResume(@PathVariable Long id) {
		        try {   // Start of the try-catch block
		            byte[] resumeData = applicants.getResume();
		            
		            if (resumeData.length == 0) {
		                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		            }
		            
		            logger.info("Sending file of size: " + resumeData.length + " bytes");

		            HttpHeaders headers = new HttpHeaders();
		            headers.setContentType(MediaType.APPLICATION_PDF);
		            headers.setContentLength(resumeData.length);  // Set the content length
		            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("resume.pdf").build());

		            return new ResponseEntity<>(resumeData, headers, HttpStatus.OK);
		        } catch (Exception e) {
		            logger.error("Error reading file", e);
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		    }
		
		*/ 
		    
		    @GetMapping("/downloadResume/{id}")
		    public ResponseEntity<byte[]> downloadResume(@PathVariable Long id) {
		        try {
		            // Fetch the specific applicant by ID from the repository
		            applicants specificApplicant = applicantsrepository.findById(id).orElse(null);
		            
		            // Check if the applicant was found
		            if (specificApplicant == null) {
		                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		            }

		            // Get the resume from the specificApplicant object
		            byte[] resumeData = specificApplicant.getResume();

		            // Ensure that the resume data exists and is not empty
		            if (resumeData == null || resumeData.length == 0) {
		                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		            }

		            logger.info("Sending file of size: " + resumeData.length + " bytes");
		            String Fullname = specificApplicant.getFirstname() + "_" +specificApplicant.getLastname();
		            System.out.println(Fullname); 
		            
		            
		            HttpHeaders headers = new HttpHeaders();
		            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		            headers.setContentLength(resumeData.length);  // Set the content length
 
		            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(Fullname + "_resume").build());

		            return new ResponseEntity<>(resumeData, headers, HttpStatus.OK);

		        } catch (Exception e) {
		            logger.error("Error reading file", e);
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		    }

		
}

	 
