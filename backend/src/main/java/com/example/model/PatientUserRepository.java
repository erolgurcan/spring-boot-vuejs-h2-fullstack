package com.example.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientUserRepository extends JpaRepository<PatientUserModel,Long>{
	
	//List<PatientUserModel> findByCard(String healthCard);
	List<PatientUserModel> findByEmail(String email);
	Optional<PatientUserModel> findByPatientId(Long patientId);
	
	@Query(value = "SELECT p, t, m FROM PatientUserModel p  JOIN TreatmentModel t ON  p.treatment = t.id JOIN MedicalUserModel m ON m.id =  t.doctor where p.patientId = :id")
	List<Object>GetFullInformation(Long id);
	

	

}
