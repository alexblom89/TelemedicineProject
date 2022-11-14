package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Models.Appointment;
import com.Telemedicine.Telemedicine.Repositories.UserRepository;
import com.Telemedicine.Telemedicine.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/appointment")
@CrossOrigin()
public class AppointmentController {

    private final AppointmentService appointmentService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping(path = "{appointmentId}")
    public Appointment getAppointmentById(@PathVariable("appointmentId") Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping
    public void registerNewAppointment(@RequestBody Appointment appointment) {
        appointmentService.addNewAppointment(appointment);
    }

    @DeleteMapping(path = "{appointmentId}")
    public void deletePatient(@PathVariable("appointmentId") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping(path = "{appointmentId}")
    public Appointment updateAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody Appointment newAppointment){
        return appointmentService.updateAppointment(appointmentId, newAppointment);
    }
}

