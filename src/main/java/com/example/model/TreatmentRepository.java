package com.example.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreatmentRepository extends JpaRepository<TreatmentModel, Long> {
	List<TreatmentModel> findByTitle(String title);
	//List<TreatmentModel> findByPatientId(Long id);
	//List<TreatmentModel> findByMedicalId(Long id);
	Optional<TreatmentModel> findById(Long id);
	

	

}
