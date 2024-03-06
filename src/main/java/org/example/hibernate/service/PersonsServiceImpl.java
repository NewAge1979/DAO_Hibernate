package org.example.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.example.hibernate.model.Person;
import org.example.hibernate.repository.PersonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsServiceImpl implements PersonsService {
    private final PersonsRepository personsRepository;
    @Override
    public List<Person> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }
}
