package org.example.hibernate.controller;

import lombok.RequiredArgsConstructor;
import org.example.hibernate.model.Person;
import org.example.hibernate.service.PersonsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonsController {
    private final PersonsService personsService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personsService.getPersonsByCity(city);
    }
}
