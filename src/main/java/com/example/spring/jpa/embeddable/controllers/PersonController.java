package com.example.spring.jpa.embeddable.controllers;

import com.example.spring.jpa.embeddable.data.Passport;
import com.example.spring.jpa.embeddable.data.Person;
import com.example.spring.jpa.embeddable.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonRepository repository;

    @GetMapping("/getByPassNumber/{num}")
    public String getByPassNumber(@PathVariable String num) {
        List<Person> personList = repository.findByPassportNumber(num);
        return "got " + personList;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> people = repository.findAll();
        return new ResponseEntity(people, HttpStatus.OK);
    }
    @GetMapping("/getById")
    public Person getById(@RequestParam String passportNum, @RequestParam String from, @RequestParam String until) {
        return repository.findById(new Passport(passportNum, from, until)).orElseGet(Person::new);
    }

    @GetMapping("/getByIds")
    public ResponseEntity<String> byFixedIds() {
        List<Person> people = repository.findAllById(List.of(new Passport("111111", "01.01.2000", "01.01.2010"), new Passport("222222", "01.01.2010", "01.01.2020")));
        return new ResponseEntity(people.toString(), HttpStatus.OK);
    }
}
