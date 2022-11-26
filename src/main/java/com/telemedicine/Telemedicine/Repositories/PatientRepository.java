package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //SELECT * FROM patient WHERE email = ?
    Patient findPatientByEmail(String email);



    //OR
    //@Query("SELECT p FROM Patient p WHERE p.email = ?1")
}
