package com.practice.javaproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;
    private String name;
    private String address;
    private String email;
    private String gender;
    private String designation;
    private Long salary;
    private Long phoneNumber;
    private int age;
    private String department;
    private List<String> hobbies;
}
