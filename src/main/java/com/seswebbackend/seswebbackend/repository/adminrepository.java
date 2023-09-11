package com.seswebbackend.seswebbackend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.seswebbackend.seswebbackend.entity.*;


public interface adminrepository extends JpaRepository<admin, Long>  {
	admin findByAdminid(String adminid);
	 
	List<admin> findAll( );	
	
}
