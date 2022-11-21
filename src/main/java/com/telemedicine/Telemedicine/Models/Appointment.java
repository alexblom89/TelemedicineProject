package com.Telemedicine.Telemedicine.Models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )

    private Long id;
    private String name;
    private String type;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "healthcare_professional_id", referencedColumnName = "id")
    private HealthcareProfessional healthcareProfessional;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=true)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Long id, String name, String type, LocalDate date, LocalTime time, HealthcareProfessional healthcareProfessional, Patient patient) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.healthcareProfessional = healthcareProfessional;
        this.patient = patient;
    }

    public Appointment(String name, String type, LocalDate date, LocalTime time, HealthcareProfessional healthcareProfessional, Patient patient) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.healthcareProfessional = healthcareProfessional;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HealthcareProfessional getHealthcareProfessional() {
        return healthcareProfessional;
    }

    public void setHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
        this.healthcareProfessional = healthcareProfessional;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", name=" + name +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
