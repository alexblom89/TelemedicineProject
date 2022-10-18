package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.Hospital;
import com.Telemedicine.Telemedicine.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public void addNewHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public void deleteHospital(Long hospitalId) {
        boolean exists = hospitalRepository.existsById(hospitalId);
        if (!exists) {
            throw new IllegalStateException("hospital with id " + hospitalId + "does not exist");
        }
        hospitalRepository.deleteById(hospitalId);
    }

    @Transactional
    public void updateHospital(Long hospitalId, String name) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalStateException(
                        "hospital with id " + hospitalId + "does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(hospital.getName(), name)) {
            hospital.setName(name);
        }
    }
}

