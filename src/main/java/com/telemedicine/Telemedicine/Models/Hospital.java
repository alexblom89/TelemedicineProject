package com.Telemedicine.Telemedicine.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Hospital extends User{
    @SequenceGenerator(
            name = "hp_sequence",
            sequenceName = "hp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hp_sequence"
    )

    private String address;
    private String phoneNumber;

    public Hospital() {
    }

    public Hospital(long id, String name, String email, String password, Collection<Role> roles, String address, String phoneNumber) {
        super(id, name, email, password, roles);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Hospital(String name, String email, String password, Collection<Role> roles, String address, String phoneNumber) {
        super(name, email, password, roles);
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "Hospital{" +
                "address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
