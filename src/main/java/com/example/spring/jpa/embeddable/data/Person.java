package com.example.spring.jpa.embeddable.data;

import jakarta.persistence.*;


@Entity
@Table(name = "person")
public class Person {

    @EmbeddedId
    Passport passport;


    @Column(name = "name")
    String firstName;
    @Column(name = "surname")
    String surname;

    

    public Person(Passport passport, String firstName, String surname) {
        this.passport = passport;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Person() {

    }

    public Passport getPassport() {
        return passport;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }



    @Override
    public String toString() {
        return "Person{" +
               "passport: " + passport.getNumber() + " issued on " + passport.getIssueDate() + " valid until " + passport.getValidUntil() +
               ", name: " + firstName +
               ", surname=" + surname +
               '}';
    }
}
