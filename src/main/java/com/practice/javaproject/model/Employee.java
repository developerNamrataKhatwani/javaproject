package com.practice.javaproject.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee {
    private String name;
    private String address;
    private String email;
    private String gender;
    private String designation;
    private Long salary;
    private Long phoneNumber;
    private int age;
    private List<String> hobbies;
}
