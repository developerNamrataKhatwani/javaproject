package com.practice.javaproject.Service;

import com.practice.javaproject.Repository.EmployeeRepository;
import com.practice.javaproject.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        // Logic to add employee
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public Employee getEmployeeById(UUID ID) {
        // Logic to get employee by ID
        // Assuming token is the employee ID for this example
        return employeeRepository.findById(ID).orElse(null);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
