package com.example.spring.jpa.embeddable.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.DataInput;
import java.io.Serializable;
import java.util.Locale;


@Embeddable
public class Passport extends UniNumber {


    @Column(name = "valid_from")
    String issueDate;
    @Column(name = "valid_until")
    String validUntil;

    public Passport() {
    }

    public Passport(String number, String issueDate, String validUntil) {
        super(number);
        this.issueDate = issueDate;
        this.validUntil = validUntil;
    }


    public String getIssueDate() {
        return issueDate;
    }

    public String getValidUntil() {
        return validUntil;
    }
}
