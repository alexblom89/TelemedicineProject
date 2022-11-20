package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findAllByPatientId(Long id, Sort sort);
    List<Appointment> findAllByHealthcareProfessionalId(Long id, Sort sort);
}
