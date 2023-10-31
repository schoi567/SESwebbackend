package com.seswebbackend.seswebbackend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.seswebbackend.seswebbackend.entity.*;


 
public interface applicantsrepository extends JpaRepository<applicants, Long> {
 
	applicants findByid(Long id);	
	void deleteById(Long id);	
 
 
	
}
  