package com.Telemedicine.Telemedicine;

import com.Telemedicine.Telemedicine.Models.Role;
import com.Telemedicine.Telemedicine.Models.User;
import com.Telemedicine.Telemedicine.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

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
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User( "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User("Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User("Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User("Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));


			userService.addRoleToUser("jim", "ROLE_USER");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
		};
		}

}
