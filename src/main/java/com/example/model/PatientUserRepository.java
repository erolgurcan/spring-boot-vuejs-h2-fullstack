package com.example.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientUserRepository extends JpaRepository<PatientUserModel,Long>{
	
	//List<PatientUserModel> findByCard(String healthCard);
	List<PatientUserModel> findByEmail(String email);
	List<PatientUserModel> findByPatientId(Long patientId);
	

}
