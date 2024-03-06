package org.example.hibernate.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class PersonKey implements Serializable {
    private String name;
    private String surname;
    private int age;
}
