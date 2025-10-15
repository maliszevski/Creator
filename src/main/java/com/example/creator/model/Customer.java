package com.example.creator.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // automatyczne generowanie wartości klucza przy wstawianiu rekordu (np. AUTO_INCREMENT w MySQL).

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    @Column(name = "e_mail")
    private String email;
    private String address;
    private String postcode;
    private int nipNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getNipNumber() {
        return nipNumber;
    }

    public void setNipNumber(int nipNumber) {
        this.nipNumber = nipNumber;
    }
}
