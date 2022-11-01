package com.Telemedicine.Telemedicine;

import com.Telemedicine.Telemedicine.Models.Role;
import com.Telemedicine.Telemedicine.Models.User;
import com.Telemedicine.Telemedicine.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class TelemedicineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemedicineApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
			userService.saveRole(new Role("Doctor"));

			userService.saveUser(new User("john","bruh","1234",new ArrayList<>()));

			userService.addRoleToUser("bruh","Doctor");
		};
		}

}
