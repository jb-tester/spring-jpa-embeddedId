package com.example.spring.jpa.embeddable.repository;

import com.example.spring.jpa.embeddable.data.Passport;
import com.example.spring.jpa.embeddable.data.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends Repository<Person, Passport> {

    List<Person> findAll();
    List<Person> findByPassportNumber(String passport_number);
    // https://youtrack.jetbrains.com/issue/IDEA-369671/Spring-JPA-findById-findAllById-methods-are-reported-as-errors-in-case-of-EmbeddedId
    Optional<Person> findById(Passport passport);
    List<Person> findAllById(Iterable<Passport> passports);
}
