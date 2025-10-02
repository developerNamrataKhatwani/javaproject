package com.practice.javaproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Employee {
    //JDBCTypeCode is used to specify the SQL type of column in the database.
    // In this case, it was "BLOB" in the DB and the annotation indicates that the ID field should be stored as a CHAR type and not BLOB.
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID ID;
    private String name;
    private String address;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "M|F|Other", message = "Please give a valid gender format")
    private String gender;
    private String designation;
    private Long salary;
    @Digits(integer = 10, fraction = 0, message = "Phone number should be valid")
    private long phoneNumber;
    private int age;
    private String department;
    private List<String> hobbies;
}
