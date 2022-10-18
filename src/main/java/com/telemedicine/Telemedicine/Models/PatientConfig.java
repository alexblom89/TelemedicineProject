//package com.Telemedicine.Telemedicine.Models;
//
//import com.Telemedicine.Telemedicine.Repositories.PatientRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.time.Month.*;
//
//@Configuration
//public class PatientConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(PatientRepository repository) {
//        return args -> {
//            Patient alex = new Patient(
//                    1L,
//                    "Alex",
//                    "asblom@lakeheadu.ca",
//                    LocalDate.of(1989, OCTOBER, 4),
//                    diseases);
//
//            Patient john = new Patient(
//                    "John",
//                    "john@lakeheadu.ca",
//                    LocalDate.of(1989, OCTOBER, 4));
//
//            repository.saveAll(
//                    List.of(alex, john)
//            );
//        };
//    }
//}
