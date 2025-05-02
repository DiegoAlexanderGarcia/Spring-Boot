package com.diego.demojpa.infrastructure.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RolDuplicateExeption extends RuntimeException {

    private String messege;
    private HttpStatus status;

    public RolDuplicateExeption(String messege, HttpStatus status) {
        super(messege);
        this.messege = messege;
        this.status = status;
    }
}
