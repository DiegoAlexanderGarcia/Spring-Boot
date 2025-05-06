package com.diego.demojpa.domain.dto;

public class PersonRequest {
    private String surname, name, sckill, passport;

    public PersonRequest() {
    }

    public PersonRequest(String surname, String name, String sckill) {
        this.surname = surname;
        this.name = name;
        this.sckill = sckill;
    }

    public PersonRequest(String surname, String name, String sckill, String passport) {
        this.surname = surname;
        this.name = name;
        this.sckill = sckill;
        this.passport = passport;
    }
    
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSkill() {
        return sckill;
    }
    public void setSckill(String sckill) {
        this.sckill = sckill;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
