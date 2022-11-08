package com.Telemedicine.Telemedicine.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "healthcareProfessional")
public class HealthcareProfessional {

    @Id
    @SequenceGenerator(
            name = "hp_sequence",
            sequenceName = "hp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hp_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String password;
    private String address;
    private String phoneNumber;
    private String specialty;

    public HealthcareProfessional() {
    }

    public HealthcareProfessional(Long id, String name, String email, LocalDate dob, String password, String address, String phoneNumber, String specialty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public HealthcareProfessional(String name, String email, LocalDate dob, String password, String address, String phoneNumber, String specialty) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "HealthcareProfessional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
