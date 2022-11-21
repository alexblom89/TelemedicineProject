package com.Telemedicine.Telemedicine.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class Patient extends User {

    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )

    private int age;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String diseases;
    private String allergies;
    private String prescriptions;
    private boolean emergency;


    public Patient() {
    }

    public Patient(long id, String name, String email, String password, Collection<Role> roles, int age, LocalDate dob, String address, String phoneNumber, String diseases, String allergies, String prescriptions, boolean emergency) {
        super(id, name, email, password, roles);
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diseases = diseases;
        this.allergies = allergies;
        this.prescriptions = prescriptions;
        this.emergency = emergency;
    }

    public Patient(String name, String email, String password, Collection<Role> roles, int age, LocalDate dob, String address, String phoneNumber, String diseases, String allergies, String prescriptions, boolean emergency) {
        super(name, email, password, roles);
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diseases = diseases;
        this.allergies = allergies;
        this.prescriptions = prescriptions;
        this.emergency = emergency;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

}
