package org.example.hibernate.service;

import org.example.hibernate.model.Person;

import java.util.List;

public interface PersonsService {
    List<Person> getPersonsByCity(String city);
}
