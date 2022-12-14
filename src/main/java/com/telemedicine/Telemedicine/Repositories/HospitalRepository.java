package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
