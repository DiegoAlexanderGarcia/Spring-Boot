package com.diego.demojpa.domain.dto;

public class PersonRequest {
    private String surname, name, sckill;

    public PersonRequest() {
    }

    public PersonRequest(String surname, String name, String sckill) {
        this.surname = surname;
        this.name = name;
        this.sckill = sckill;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSckill() {
        return sckill;
    }
    public void setSckill(String sckill) {
        this.sckill = sckill;
    }
}
