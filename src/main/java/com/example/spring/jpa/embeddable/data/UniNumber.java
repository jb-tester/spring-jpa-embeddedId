package com.example.spring.jpa.embeddable.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
public abstract class UniNumber implements Serializable {
    @Column(name = "passport_number")
    String number;

    public UniNumber(String number) {
        this.number = number;
    }

    public UniNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}