package com.Telemedicine.Telemedicine.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //SELECT * FROM patient WHERE email = ?
    Optional<Patient> findPatientByEmail(String email);

    //OR
    //@Query("SELECT p FROM Patient p WHERE p.email = ?1")
}
