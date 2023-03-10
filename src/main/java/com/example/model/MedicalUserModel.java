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
@Table(name = "MedicalUser")
public class MedicalUserModel {

	public MedicalUserModel() {
		
	}
	
    public MedicalUserModel( String userFullName, String email, String gender, int medicalID,
			String password, String role) {
    	
		this.userFullName = userFullName;
		this.email = email;
		this.gender = gender;
		this.medicalID = medicalID;
		this.password = password;
		Role = role;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userFullname")
    private String userFullName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "medicalID")
    private Integer medicalID;

    @Column(name = "password")
    private String password;

    @Column(name = "Role")
    private String Role = "admin";
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<TreatmentModel> treatments = new HashSet<>();
    
    
	public void addTreatment(TreatmentModel treat) {
		this.treatments.add(treat);
		treat.setDoctor(this);
		
	}

   

	public Set<TreatmentModel> getTreatments() {
		return treatments;
	}

	public void setTreatments(Set<TreatmentModel> treatments) {
		this.treatments = treatments;
	}

	public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserFullName() {
        return this.userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMedicalID() {
        return this.medicalID;
    }

    public void setMedicalID(int medicalID) {
        this.medicalID = medicalID;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
}