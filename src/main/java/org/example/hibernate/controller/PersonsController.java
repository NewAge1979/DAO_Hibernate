package org.example.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.example.hibernate.model.Person;
import org.example.hibernate.service.PersonsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Secured(value={"ROLE_READ"})
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personsService.getPersonsByCity(city);
    }

    @RolesAllowed(value={"WRITE"})
    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam Integer age) {
        return personsService.getPersonsByAge(age);
    }

    @PreAuthorize("hasRole('WRITE') || hasRole('DELETE')")
    @GetMapping("/by-name-surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personsService.getPersonsByNameAndSurname(name, surname);
    }

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/user")
    public String getUserInfo(@RequestParam String username) {
        return String.format("Username: %s", username);
    }
}