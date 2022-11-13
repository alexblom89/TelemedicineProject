package com.Telemedicine.Telemedicine.Models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

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
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=true)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Long id, String name, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Appointment(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
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
