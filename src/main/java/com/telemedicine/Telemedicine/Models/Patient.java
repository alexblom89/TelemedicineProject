package com.Telemedicine.Telemedicine.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

@Entity
@Table
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String password;
    private String address;
    private String phoneNumber;
    private String diseases;
    private String allergies;
    private String prescriptions;
    @Transient //Annotation means that this does not need to be a database column.
    private int age;

    public Patient() {
    }

    public Patient(Long id, String name, String email, LocalDate dob, String password,
                   String address, String phoneNumber, String diseases, String allergies, String prescriptions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diseases = diseases;
        this.allergies = allergies;
        this.prescriptions = prescriptions;
    }

    public Patient(String name, String email, LocalDate dob, String password, String address,
                   String phoneNumber, String diseases, String allergies, String prescriptions) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diseases = diseases;
        this.allergies = allergies;
        this.prescriptions = prescriptions;
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

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
