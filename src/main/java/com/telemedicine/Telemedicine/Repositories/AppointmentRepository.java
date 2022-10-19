package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
