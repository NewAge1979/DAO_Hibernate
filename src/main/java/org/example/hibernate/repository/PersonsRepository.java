package org.example.hibernate.repository;

import org.example.hibernate.model.Person;
import org.example.hibernate.model.PersonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, PersonKey> {
    @Query("Select t1 From Person t1 Where t1.city = :city")
    List<Person> queryPersonByCity(@Param("city") String city);
    @Query("Select t1 From Person t1 Where t1.id.age < :age Order By t1.id.age")
    List<Person> queryPersonByAge(@Param("age") Integer age);
    @Query("Select t1 From Person t1 Where t1.id.name = :name And t1.id.surname = :surname")
    Optional<List<Person>> queryPersonByNameSurname(@Param("name") String name, @Param("surname") String surname);
}