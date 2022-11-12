package com.Telemedicine.Telemedicine.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table
public class HealthcareProfessional extends User {

    @SequenceGenerator(
            name = "hp_sequence",
            sequenceName = "hp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hp_sequence"
    )

    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String specialty;

    public HealthcareProfessional() {
    }

    public HealthcareProfessional(long id, String name, String email, String password, Collection<Role> roles, LocalDate dob, String address, String phoneNumber, String specialty) {
        super(id, name, email, password, roles);
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public HealthcareProfessional(String name, String email, String password, Collection<Role> roles, LocalDate dob, String address, String phoneNumber, String specialty) {
        super(name, email, password, roles);
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}


