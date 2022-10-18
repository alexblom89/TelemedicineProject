package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.HealthcareProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<HealthcareProfessional, Long> {

}
