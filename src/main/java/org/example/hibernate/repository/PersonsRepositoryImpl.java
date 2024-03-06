package org.example.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.example.hibernate.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonsRepositoryImpl implements PersonsRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createNamedQuery("getPersByCity");
        query.setParameter("city", city);
        return (List<Person>) query.getResultList();
    }
}
