package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.Patient;
import com.Telemedicine.Telemedicine.Repositories.PatientRepository;
import com.Telemedicine.Telemedicine.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientOptional = Optional.ofNullable(patientRepository.findPatientByEmail(patient.getEmail()));
        if (patientOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patient.getRoles().add(roleRepository.findByName("ROLE_PATIENT"));
        patient.setEmergency(false);
        patient.setAge(Period.between(patient.getDob(), LocalDate.now()).getYears());
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        boolean exists = patientRepository.existsById(patientId);
        if (!exists) {
            throw new IllegalStateException("patient with id " + patientId + "does not exist");
        }
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public void updatePatient(Long patientId, String name, String email,boolean emergency) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException(
                    "patient with id " + patientId + "does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(patient.getName(), name)) {
            patient.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(patient.getEmail(), email)) {
            Optional<Patient> patientOptional = Optional.ofNullable(patientRepository.findPatientByEmail(email));
            if (patientOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            patient.setEmail(email);
        }
        if(!emergency){
            patient.setEmergency(true);
        }
    }
}
