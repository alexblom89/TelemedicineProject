package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.HealthcareProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthcareProfessionalRepository extends JpaRepository<HealthcareProfessional, Long> {
    Optional<HealthcareProfessional> findHealthcareProfessionalByEmail(String email);
}
