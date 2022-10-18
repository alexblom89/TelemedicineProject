package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.HealthcareProfessional;
import com.Telemedicine.Telemedicine.Repositories.HealthcareProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HealthcareProfessionalService {

    private final HealthcareProfessionalRepository healthcareProfessionalRepository;

    @Autowired
    public HealthcareProfessionalService(HealthcareProfessionalRepository healthcareProfessionalRepository) {
        this.healthcareProfessionalRepository = healthcareProfessionalRepository;
    }

    public List<HealthcareProfessional> getHealthcareProfessionals() {
        return healthcareProfessionalRepository.findAll();
    }

    public void addNewHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
        Optional<HealthcareProfessional> healthcareProfessionalOptional = healthcareProfessionalRepository.findHealthcareProfessionalByEmail(healthcareProfessional.getEmail());
        if (healthcareProfessionalOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        healthcareProfessionalRepository.save(healthcareProfessional);
    }

    public void deleteHealthcareProfessional(Long healthcareProfessionalId) {
        boolean exists = healthcareProfessionalRepository.existsById(healthcareProfessionalId);
        if (!exists) {
            throw new IllegalStateException("healthcareProfessional with id " + healthcareProfessionalId + "does not exist");
        }
        healthcareProfessionalRepository.deleteById(healthcareProfessionalId);
    }

    @Transactional
    public void updateHealthcareProfessional(Long healthcareProfessionalId, String name, String email) {
        HealthcareProfessional healthcareProfessional = healthcareProfessionalRepository.findById(healthcareProfessionalId)
                .orElseThrow(() -> new IllegalStateException(
                        "healthcareProfessional with id " + healthcareProfessionalId + "does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(healthcareProfessional.getName(), name)) {
            healthcareProfessional.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(healthcareProfessional.getEmail(), email)) {
            Optional<HealthcareProfessional> healthcareProfessionalOptional = healthcareProfessionalRepository.findHealthcareProfessionalByEmail(email);
            if (healthcareProfessionalOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            healthcareProfessional.setEmail(email);
        }
    }
}
