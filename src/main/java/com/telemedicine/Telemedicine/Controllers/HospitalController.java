package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Models.Hospital;
import com.Telemedicine.Telemedicine.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/hospital")
@CrossOrigin()
public class HospitalController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }

    @PostMapping
    public void registerNewHospital(@RequestBody Hospital hospital) {
        hospitalService.addNewHospital(hospital);
    }

    @DeleteMapping(path = "{hospitalId}")
    public void deleteHospital(@PathVariable("hospitalId") Long hospitalId) {
        hospitalService.deleteHospital(hospitalId);
    }

    @PutMapping(path = "{hospitalId}")
    public void updateHospital(@PathVariable("hospitalId") Long hospitalId,
                              @RequestParam(required = false) String name) {
        hospitalService.updateHospital(hospitalId, name);
    }
}
