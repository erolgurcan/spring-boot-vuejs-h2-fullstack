package com.example.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MedicalUserRepository extends JpaRepository<MedicalUserModel, Long> {

	List<MedicalUserModel> findByEmail(String email);

	List<MedicalUserModel> findBymedicalID(int id);

	@Query(value = "SELECT m FROM MedicalUserModel m LEFT JOIN FETCH m.treatments where m.id = :id")
	Optional<MedicalUserModel> findByIdEagerly(Long id);

}
