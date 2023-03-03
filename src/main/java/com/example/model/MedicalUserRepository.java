package com.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalUserRepository extends JpaRepository<MedicalUserModel, Long> {

	
	List <MedicalUserModel> findByEmail (String email); 
	List <MedicalUserModel> findBymedicalID (int id);
	
	
}
