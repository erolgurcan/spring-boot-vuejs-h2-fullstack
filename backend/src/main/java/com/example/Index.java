package com.example;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.MedicalUserModel;
import com.example.model.MedicalUserRepository;
import com.example.model.PatientUserModel;
import com.example.model.PatientUserRepository;
import com.example.model.TreatmentModel;
import com.example.model.TreatmentRepository;

@SpringBootApplication
public class Index {

	public static void main(String[] args) {
		SpringApplication.run(Index.class, args);
	}
	
	private void loadInitialData(MedicalUserRepository muRepo, PatientUserRepository puRepo, TreatmentRepository tRepo) {
		ArrayList<MedicalUserModel> doctors = new ArrayList<>();
		doctors.add(new MedicalUserModel("Elon Musk", "elonmusk@something.com", "male", 1001, "12345", "admin"));
		doctors.add(new MedicalUserModel("Mark Zuckerberg", "markzuckerberg@something.com", "male", 1002, "54321", "admin"));
		doctors.add(new MedicalUserModel("Steve Jobs", "stevejobs@something.com", "male", 1003, "67890", "admin"));
		doctors.add(new MedicalUserModel("Bill Gates", "billgates@something.com", "male", 1004, "abcdef", "admin"));
		doctors.add(new MedicalUserModel("Tim Cook", "timcook@something.com", "male", 1005, "qwerty", "admin"));
		doctors.add(new MedicalUserModel("Larry Page", "larrypage@something.com", "male", 1006, "password", "admin"));
		doctors.add(new MedicalUserModel("Sergey Brin", "sergeybrin@something.com", "male", 1007, "secret", "admin"));
		doctors.add(new MedicalUserModel("Sundar Pichai", "sundarpichai@something.com", "male", 1008, "secure", "admin"));
		doctors.add(new MedicalUserModel("Jack Ma", "jackma@something.com", "male", 1009, "1234", "admin"));
		doctors.add(new MedicalUserModel("Masayoshi Son", "masayoshison@something.com", "male", 1010, "5678", "admin"));
		
		ArrayList<PatientUserModel> patients = new ArrayList<>();
		patients.add(new PatientUserModel("Bill Clinton","19-06-1998","Male","bill@clinton.com","123456789","1234","abc, 123 st","Vancouver","BC","V1V1V2", "1234"));
		patients.add(new PatientUserModel("Barak Obama","12-03-1997","Male","barak@obama.com","113456789","1134","abd, 124 st","Vancouver","BC","V1V2V2", "1234"));
		patients.add(new PatientUserModel("Hillary Clinton","10-04-1996","Female","hillary@clinton.com","123456780","1233","abc, 123 st","Vancouver","BC","V1V1V2", "1234"));
		patients.add(new PatientUserModel("Joe Biden","13-05-1992","Male","joe@biden.com","223456789","1434","abe, 125 st","Vancouver","BC","V1V3V2", "1234"));

		
		ArrayList<TreatmentModel> treatments = new ArrayList<>();		
		treatments.add(new TreatmentModel("Cut on hand","Apply Gauze on the injury",
				"Gauze","Apply Gauze on the injury"));
		treatments.add(new TreatmentModel("Cut on arm","Cover the wound with a bandage",
				"bandage","Wash the wound first and stop the bleeding"));
		treatments.add(new TreatmentModel("Injury on leg","Apply the ointment over the wound and "
				+ "cover it with some bandage","Antibiotic Ointment, bandage","Wash the wound first and stop the bleeding"));
		treatments.add(new TreatmentModel("Minor burn on index finger","Apply lotion and bandage the burn, take a paiin reliever",
				"Lotion, bandage, pain reliever","Cool the burn under cool running water first, don't break blisters"));
		treatments.add(new TreatmentModel("Strain in the leg","Hold ice on the area for 20 minutes, "
				+ "wrap an elastic bandage or splint around the strain, "
				+ "put a pillow under the injured leg to keep it raised","Elastic bandage, pillow, ice",
				"Rest the limb to give it a chance to heal"));
		treatments.add(new TreatmentModel("Cut on hand","Apply Gauze on the injury",
				"Gauze","Apply Gauze on the injury"));
		treatments.add(new TreatmentModel("Cut on arm","Cover the wound with a bandage",
				"bandage","Wash the wound first and stop the bleeding"));
		treatments.add(new TreatmentModel("Injury on leg","Apply the ointment over the wound and "
				+ "cover it with some bandage","Antibiotic Ointment, bandage","Wash the wound first and stop the bleeding"));
		treatments.add(new TreatmentModel("Minor burn on index finger","Apply lotion and bandage the burn, take a paiin reliever",
				"Lotion, bandage, pain reliever","Cool the burn under cool running water first, don't break blisters"));
		treatments.add(new TreatmentModel("Strain in the leg","Hold ice on the area for 20 minutes, "
				+ "wrap an elastic bandage or splint around the strain, "
				+ "put a pillow under the injured leg to keep it raised","Elastic bandage, pillow, ice",
				"Rest the limb to give it a chance to heal"));
		
		for(int i=0;i<doctors.size();i++) {
			
			doctors.get(i).addTreatment(treatments.get(i));
		}
		
		muRepo.saveAll(doctors);
		
		tRepo.saveAll(treatments);		
		
		for(int i=0;i<patients.size();i++) {
			patients.get(i).setTreatment(treatments.get(i));;
		}
		
		puRepo.saveAll(patients);	
		
	}

	@Bean
	ApplicationRunner init(MedicalUserRepository muRepo, PatientUserRepository puRepo, TreatmentRepository tRepo) {

		return (arg) -> {
			loadInitialData(muRepo , puRepo , tRepo);

	/*
			muRepo.save(new MedicalUserModel("Elon Musk", "elonmusk@something.com", "male", 1001, "12345", "admin"));
			muRepo.save(new MedicalUserModel("Mark Zuckerberg", "markzuckerberg@something.com", "male", 1002, "54321", "admin"));
			muRepo.save(new MedicalUserModel("Steve Jobs", "stevejobs@something.com", "male", 1003, "67890", "admin"));
			muRepo.save(new MedicalUserModel("Bill Gates", "billgates@something.com", "male", 1004, "abcdef", "admin"));
			muRepo.save(new MedicalUserModel("Tim Cook", "timcook@something.com", "male", 1005, "qwerty", "admin"));
			muRepo.save(new MedicalUserModel("Larry Page", "larrypage@something.com", "male", 1006, "password", "admin"));
			muRepo.save(new MedicalUserModel("Sergey Brin", "sergeybrin@something.com", "male", 1007, "secret", "admin"));
			muRepo.save(new MedicalUserModel("Sundar Pichai", "sundarpichai@something.com", "male", 1008, "secure", "admin"));
			muRepo.save(new MedicalUserModel("Jack Ma", "jackma@something.com", "male", 1009, "1234", "admin"));
			muRepo.save(new MedicalUserModel("Masayoshi Son", "masayoshison@something.com", "male", 1010, "5678", "admin"));
			puRepo.save(new PatientUserModel("Bill Clinton","19-06-1998","Male","bill@clinton.com","123456789","1234","abc, 123 st","Vancouver","BC","V1V1V2"));
			puRepo.save(new PatientUserModel("Barak Obama","12-03-1997","Male","barak@obama.com","113456789","1134","abd, 124 st","Vancouver","BC","V1V2V2"));
			puRepo.save(new PatientUserModel("Hillary Clinton","10-04-1996","Female","hillary@clinton.com","123456780","1233","abc, 123 st","Vancouver","BC","V1V1V2"));
			puRepo.save(new PatientUserModel("Joe Biden","13-05-1992","Male","joe@biden.com","223456789","1434","abe, 125 st","Vancouver","BC","V1V3V2"));
			tRepo.save(new TreatmentModel("Injury on hand","Apply Gauze on the injury","Gauze","Apply Gauze on the injury",1,1));*/
		};
	
	}
	}
