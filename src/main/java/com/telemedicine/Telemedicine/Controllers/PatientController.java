package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Models.Patient;
import com.Telemedicine.Telemedicine.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/patient")
@CrossOrigin()
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient) {
        patientService.addNewPatient(patient);
    }

    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "{patientId}")
    public void updatePatient(@PathVariable("patientId") Long patientId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email,
                              @RequestParam(required = false) boolean emergency) {
        patientService.updatePatient(patientId, name, email,emergency);
    }
}
