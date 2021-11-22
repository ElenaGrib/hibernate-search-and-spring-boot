package com.example.hibernatesearchandspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Indexed
@NoArgsConstructor
public class Employee {
    private @Id @GeneratedValue Long id;
    @Field
    private String firstName;
    @Field
    private String lastName;

    public Employee(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
