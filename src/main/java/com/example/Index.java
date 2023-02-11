package com.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.MedicalUserModel;
import com.example.model.MedicalUserRepository;

@SpringBootApplication
public class Index {

	public static void main(String[] args) {
		SpringApplication.run(Index.class, args);
	}

	@Bean
	ApplicationRunner init(MedicalUserRepository muRepo) {

		return (arg) -> {

	
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

			
			

		};

	}
}
