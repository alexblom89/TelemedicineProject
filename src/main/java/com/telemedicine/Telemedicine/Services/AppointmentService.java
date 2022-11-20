package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.Appointment;
import com.Telemedicine.Telemedicine.Repositories.AppointmentRepository;
import com.Telemedicine.Telemedicine.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public List<Appointment> getAppointments() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long id = userRepository.findByEmail(auth.getName()).getId();
        if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_HP"))) {
            return appointmentRepository.findAllByHealthcareProfessionalId(id,Sort.by(Sort.Direction.ASC,"date","time","patient.age"));
        }else
            return appointmentRepository.findAllByPatientId(id, Sort.by(Sort.Direction.ASC,"date","time"));
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "appointment with id " + appointmentId + "does not exist"
                ));
    }

    public void addNewAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long appointmentId) {
        boolean exists = appointmentRepository.existsById(appointmentId);
        if (!exists) {
            throw new IllegalStateException("appointment with id " + appointmentId + "does not exist");
        }
        appointmentRepository.deleteById(appointmentId);
    }

    @Transactional
    public Appointment updateAppointment(Long appointmentId, Appointment newAppointment) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointment.setName(newAppointment.getName());
                    appointment.setDate(newAppointment.getDate());
                    appointment.setTime(newAppointment.getTime());
                    appointment.setHealthcareProfessional(newAppointment.getHealthcareProfessional());
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(() -> new IllegalStateException(
                        "appointment with id " + appointmentId + "does not exist"
                ));
    }
}
