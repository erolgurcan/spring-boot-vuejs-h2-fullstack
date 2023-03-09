package com.example.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Treatment")
public class TreatmentModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="treatProcess")
	private String treatProcess;
	
	@Column(name="materials")
	private String materials;
	
	@Column(name="tips")
	private String tips;
	
	@OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JsonIgnore
	private Set<PatientUserModel> patients = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "medicalUser_id", nullable = false)
	private MedicalUserModel doctor;
	
	

	public TreatmentModel() {
		
	}



	public TreatmentModel(String title, String treatProcess, String materials, String tips) {
		this.title = title;
		this.treatProcess = treatProcess;
		this.materials = materials;
		this.tips = tips;

		
	}

	public void addPatient(PatientUserModel patient) {
		this.patients.add(patient);
		patient.setTreatment(this);
	}
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTreatProcess() {
		return treatProcess;
	}



	public void setTreatProcess(String treatProcess) {
		this.treatProcess = treatProcess;
	}



	public String getMaterials() {
		return materials;
	}



	public void setMaterials(String materials) {
		this.materials = materials;
	}



	public String getTips() {
		return tips;
	}



	public void setTips(String tips) {
		this.tips = tips;
	}



	public Set<PatientUserModel> getPatient() {
		return patients;
	}



	public void setPatient(Set<PatientUserModel> patient) {
		this.patients = patient;
	}


	public MedicalUserModel getDoctor() {
		return doctor;
	}



	public void setDoctor(MedicalUserModel doctor) {
		this.doctor = doctor;
	}



	
	
	
	

}
