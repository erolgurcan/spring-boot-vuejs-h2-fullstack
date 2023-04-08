package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MedicalUserModel;
import com.example.model.MedicalUserRepository;
import com.example.model.PatientUserModel;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MedicalUserController {

	@Autowired
	MedicalUserRepository medicalUserRepository;
	
	@GetMapping("/medicalLogin/{email}")
	public ResponseEntity<List> getMedicByEmail(@PathVariable("email") String email ){
		
		List<MedicalUserModel> medicalData = medicalUserRepository.findByEmail(email);
		
		
		if (medicalData.size() != 0) {
			return new ResponseEntity<>(medicalData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/medicalUsers/{medicalID}")
	public ResponseEntity<List> getMedicByEmail(@PathVariable("medicalID") Integer medicalID ){
		
		List<MedicalUserModel> medicalData = medicalUserRepository.findBymedicalID(medicalID);
		
		
		if (medicalData.size() != 0) {
			return new ResponseEntity<>(medicalData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/medicalUsers")
	public ResponseEntity<List<MedicalUserModel>> getAllMedicalUsers(
			@RequestParam(required = false) Integer medicalID) {

		try {
			List<MedicalUserModel> result;

			if (medicalID == null) {
				result = medicalUserRepository.findAll();

				return result.size() > 0 ? new ResponseEntity<List<MedicalUserModel>>(result, HttpStatus.OK)
						: new ResponseEntity("No result found", HttpStatus.NO_CONTENT);

			} else {
				result = medicalUserRepository.findBymedicalID(medicalID);

				return result.size() > 0 ? new ResponseEntity<List<MedicalUserModel>>(result, HttpStatus.OK)
						: new ResponseEntity("No result found", HttpStatus.NO_CONTENT);
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/medicalUsers") // user story: 7
	public ResponseEntity<MedicalUserModel> addNewMedicalUser(@RequestBody MedicalUserModel newMedicalUser) {
		try {
			medicalUserRepository.save(newMedicalUser);
			return new ResponseEntity<>(newMedicalUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/medicalUsers/{id}")
	public ResponseEntity<String> deleteMedicalUser(@PathVariable Long id) {
		try {
			System.out.println(id);
			medicalUserRepository.deleteById(id);
			return new ResponseEntity<>("Medical User deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/medicalUsers")
	public ResponseEntity<String> deleteAllMedicalUsers() {
		try {
			medicalUserRepository.deleteAll();
			return new ResponseEntity<>("All medical users deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
