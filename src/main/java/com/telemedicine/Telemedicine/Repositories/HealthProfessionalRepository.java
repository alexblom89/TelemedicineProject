package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.HealthcareProfessional;
import com.Telemedicine.Telemedicine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthcareProfessional, Long> {
    Optional<HealthcareProfessional> findHealthcareProfessionalsByEmail(String email);
}
