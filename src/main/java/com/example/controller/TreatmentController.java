package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MedicalUserModel;
import com.example.model.MedicalUserRepository;
import com.example.model.PatientUserModel;
import com.example.model.PatientUserRepository;
import com.example.model.TreatmentModel;
import com.example.model.TreatmentRepository;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TreatmentController {
	
	@Autowired
	TreatmentRepository treatRepo;
	
	@Autowired
	MedicalUserRepository docRepo;
	
	@Autowired
	PatientUserRepository patRepo;
	
	@GetMapping("/treatments")
	public ResponseEntity<List<TreatmentModel>> getAllTreatments(
			@RequestParam(required=false) String title){
		try {
			List<TreatmentModel> treats = new ArrayList<>();
			if(title == null) {
				treatRepo.findAll().forEach(treats::add);
			}
			else {
				treatRepo.findByTitle(title).forEach(treats::add);
			}
			if(treats.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(treats, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/medicalUsers/{id}/treatment") //user story 6
	public ResponseEntity<TreatmentModel> createTreatment(@PathVariable("id") Long id,
			@RequestBody TreatmentModel treatment){
		Optional<MedicalUserModel> doc;
		doc = docRepo.findById(id);
		
		try {
			TreatmentModel newTreat = new TreatmentModel(treatment.getTitle(), treatment.getTreatProcess(), treatment.getMaterials(), treatment.getTips());
			newTreat.setDoctor(doc.get());
			treatRepo.save(newTreat);
			return new ResponseEntity<>(newTreat, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/treatments/{treatmentId}") //user story:9
	public ResponseEntity<TreatmentModel> updateTreatment(@PathVariable("treatmentId") long treatId,
			@RequestParam long patientId){
		Optional<PatientUserModel> patient = patRepo.findById(patientId);
		Optional<TreatmentModel> treatmentData = treatRepo.findById(treatId);
		
		if(treatmentData.isPresent()) {
			TreatmentModel _treatment = treatmentData.get();
			_treatment.addPatient(patient.get());
			return new ResponseEntity<>(treatRepo.save(_treatment), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
