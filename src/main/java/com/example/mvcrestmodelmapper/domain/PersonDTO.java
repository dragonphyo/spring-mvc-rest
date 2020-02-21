package com.example.mvcrestmodelmapper.domain;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private Integer id;
    private String name;
    private String streetName;
    private String zipCode;
    private String phoneNumber;
    private int age;

    public PersonDTO(){
    }

    public PersonDTO(Integer id, String name, String streetName, String zipCode, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
