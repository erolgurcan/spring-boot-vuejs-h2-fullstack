package com.example.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreatmentRepository extends JpaRepository<TreatmentModel, Long> {
	List<TreatmentModel> findByTitle(String title);
	Optional<TreatmentModel> findById(Long id);
	

	

}
