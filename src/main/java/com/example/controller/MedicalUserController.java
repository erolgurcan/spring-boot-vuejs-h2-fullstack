package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MedicalUserModel;
import com.example.model.MedicalUserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MedicalUserController {

	@Autowired
	MedicalUserRepository medicalUserRepository;
	
	@GetMapping("/medicalUsers")
	public ResponseEntity<List<MedicalUserModel>> getAllMedicalUsers(
			@RequestParam(required = false) Integer medicalID) {

		try {
			System.out.println("Teste");
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

	@PostMapping("/medicalUsers") //user story: 7
	public ResponseEntity<MedicalUserModel> addNewMedicalUser(@RequestParam(required = true) String fullName,
			@RequestParam(required = true) String email, @RequestParam(required = false) String gender, 
			@RequestParam(required = false) int medicalID,@RequestParam(required = true) String password, 
			@RequestParam(required = false) String role) {
		try {
			MedicalUserModel newDoc = new MedicalUserModel(fullName, email, gender, medicalID,password, role);
			medicalUserRepository.save(newDoc);
			return new ResponseEntity<>(newDoc,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
