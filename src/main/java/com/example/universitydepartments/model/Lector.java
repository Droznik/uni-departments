package com.example.universitydepartments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int salary;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments = new HashSet<>();

    public Lector(String name, int salary, Degree degree) {
        this.name = name;
        this.salary = salary;
        this.degree = degree;
    }
}
