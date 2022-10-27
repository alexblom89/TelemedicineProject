package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Models.HealthcareProfessional;
import com.Telemedicine.Telemedicine.Services.HealthcareProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/healthcareProfessional")
@CrossOrigin()
public class HealthcareProfessionalController {

    private final HealthcareProfessionalService healthcareProfessionalService;

    @Autowired
    public HealthcareProfessionalController(HealthcareProfessionalService healthcareProfessionalService) {
        this.healthcareProfessionalService = healthcareProfessionalService;
    }

    @GetMapping
    public List<HealthcareProfessional> getHealthcareProfessionals() {
        return healthcareProfessionalService.getHealthcareProfessionals();
    }

    @PostMapping
    public void registerNewHealthcareProfessional(@RequestBody HealthcareProfessional healthcareProfessional) {
        healthcareProfessionalService.addNewHealthcareProfessional(healthcareProfessional);
    }

    @DeleteMapping(path = "{healthcareProfessionalId}")
    public void deleteHealthcareProfessional(@PathVariable("healthcareProfessionalId") Long healthcareProfessionalId) {
        healthcareProfessionalService.deleteHealthcareProfessional(healthcareProfessionalId);
    }

    @PutMapping(path = "{healthcareProfessionalId}")
    public void updateHealthcareProfessional(@PathVariable("healthcareProfessionalId") Long healthcareProfessionalId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        healthcareProfessionalService.updateHealthcareProfessional(healthcareProfessionalId, name, email);
    }
}
