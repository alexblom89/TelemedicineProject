package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.Hospital;
import com.Telemedicine.Telemedicine.Repositories.HospitalRepository;
import com.Telemedicine.Telemedicine.Repositories.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public HospitalService(HospitalRepository hospitalRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.hospitalRepository = hospitalRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public void addNewHospital(Hospital hospital) {
        hospital.setPassword(passwordEncoder.encode(hospital.getPassword()));
        hospital.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
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

