package com.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PatientUserModel;
import com.example.model.PatientUserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PatientUserController {
	
	@Autowired
	PatientUserRepository patientUserRepository;
	
	@GetMapping("/patientUsers")
	public ResponseEntity<List<PatientUserModel>> getAllPatientUsers(
			@RequestParam(required = false) String healthCard){
		try {
			List<PatientUserModel> result; //= new ArrayList<PatientUserModel>();
			
			if(healthCard == null) {
				result = patientUserRepository.findAll();
				
				return result.size() > 0 ? new ResponseEntity<List<PatientUserModel>>(result, HttpStatus.OK)
						: new ResponseEntity("No result found", HttpStatus.NO_CONTENT);
				
			} else {
				result = patientUserRepository.findByCard(healthCard);
				
				return result.size() > 0 ? new ResponseEntity<List<PatientUserModel>>(result, HttpStatus.OK)
						: new ResponseEntity("No result found", HttpStatus.NO_CONTENT);
			}
		} catch(Exception ex) {
			return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
		}
			
	}
	@GetMapping("/patientUsers/{id}")
	public ResponseEntity<PatientUserModel> getPatientById(@PathVariable("id") long id){
		Optional<PatientUserModel> patientData = patientUserRepository.findById(id);
		
		if(patientData.isPresent()) {
			return new ResponseEntity<>(patientData.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/patientUsers")
	public ResponseEntity<PatientUserModel> createPatientUser(@RequestBody PatientUserModel patientUserModel){
		try {
			PatientUserModel _patientUserModel = patientUserRepository.save(new PatientUserModel(patientUserModel.getFullName(), patientUserModel.getBirthDate(),patientUserModel.getGender(),patientUserModel.getEmail(),patientUserModel.getPhone(),patientUserModel.getHealthCard(),patientUserModel.getAddress(),patientUserModel.getCity(),patientUserModel.getProvince(),patientUserModel.getZipCode()));
			return new ResponseEntity<>(_patientUserModel, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/patientUsers/{id}")
	public ResponseEntity<PatientUserModel> updatePatientUser(@PathVariable("id") long id,@RequestBody PatientUserModel patientUserModel){
		Optional<PatientUserModel> patientData = patientUserRepository.findById(id);
		
		if (patientData.isPresent()) {
			PatientUserModel _patientUserModel = patientData.get();
			_patientUserModel.setFullName(patientUserModel.getFullName());
			_patientUserModel.setBirthDate(patientUserModel.getBirthDate());
			_patientUserModel.setGender(patientUserModel.getGender());
			_patientUserModel.setEmail(patientUserModel.getEmail());
			_patientUserModel.setPhone(patientUserModel.getPhone());
			_patientUserModel.setHealthCard(patientUserModel.getHealthCard());
			_patientUserModel.setAddress(patientUserModel.getAddress());
			_patientUserModel.setCity(patientUserModel.getCity());
			_patientUserModel.setProvince(patientUserModel.getProvince());
			_patientUserModel.setZipCode(patientUserModel.getZipCode());
			return new ResponseEntity<>(patientUserRepository.save(_patientUserModel),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/patientUsers/{id}")
	public ResponseEntity<HttpStatus> deletePatientUser(@PathVariable("id") long id){
		try {
			patientUserRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/patientUsers")
	public ResponseEntity<HttpStatus> deleteAllPatientUsers(){
		try {
			patientUserRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
