package org.example.hibernate.repository;

import org.example.hibernate.model.Person;
import org.example.hibernate.model.PersonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, PersonKey> {
    List<Person> findPersonByCity(String city);
    List<Person> findPersonById_AgeLessThanOrderById_AgeAsc(Integer age);
    Optional<List<Person>> findPersonById_NameAndAndId_Surname(String name, String surname);
}