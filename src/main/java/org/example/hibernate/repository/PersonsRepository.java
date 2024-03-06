package org.example.hibernate.repository;

import org.example.hibernate.model.Person;

import java.util.List;

public interface PersonsRepository {
    List<Person> getPersonsByCity(String city);
}
