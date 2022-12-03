package com.Telemedicine.Telemedicine;

import com.Telemedicine.Telemedicine.Models.*;
import com.Telemedicine.Telemedicine.Services.HealthcareProfessionalService;
import com.Telemedicine.Telemedicine.Services.HospitalService;
import com.Telemedicine.Telemedicine.Services.PatientService;
import com.Telemedicine.Telemedicine.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class TelemedicineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemedicineApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserService userService, PatientService patientService, HealthcareProfessionalService healthcareProfessionalService, HospitalService hospitalService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_PATIENT"));
			userService.saveRole(new Role(null, "ROLE_HP"));
			userService.saveRole(new Role(null, "ROLE_HOSPITAL"));

			patientService.addNewPatient(new Patient("Jim", "jim", "1234",new ArrayList<>(),60,LocalDate.parse("2001-04-03"), "3425 Derek Drive", "7473824325", "", "", "",false));
			patientService.addNewPatient(new Patient("Jake", "jake", "1234",new ArrayList<>(),68,LocalDate.parse("2001-04-03"), "3425 Derek Drive", "7473824325", "", "", "", false));
			healthcareProfessionalService.addNewHealthcareProfessional(new HealthcareProfessional("Will", "will", "1234", new ArrayList<>(), LocalDate.parse("2001-04-03"),"4328 Fairfax Drive","7623546323","Eye"));
			healthcareProfessionalService.addNewHealthcareProfessional(new HealthcareProfessional("bob", "bob", "1234", new ArrayList<>(), LocalDate.now(),"4328 Fairfax Drive","7623546323","Muscle"));
			hospitalService.addNewHospital(new Hospital("Orillia Hopital", "orillia", "1234", new ArrayList<>(),"1236 Payne Street","3124252123"));
		};
		}

}
