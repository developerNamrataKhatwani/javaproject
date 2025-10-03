package com.practice.javaproject.Streams;

import com.practice.javaproject.Service.EmployeeService;
import com.practice.javaproject.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class LearnStreams {
    //Java Streams API is a powerful feature introduced in Java 8 that allows for functional-style operations on collections of objects. It provides a way to process sequences of elements (like collections, arrays, or I/O resources) in a declarative manner, enabling developers to write more concise and readable code.
    // Streams support various operations such as filtering, mapping, reducing, and collecting data. They can be either sequential or parallel, allowing for efficient processing of large datasets.
    // Streams are not data structures; instead they have operations that can be performed on them. They are designed to work with lambda expressions.
    // There are three main components of the Streams API: Source, Intermediate Operations, and Terminal Operations.
    // Source: The source of a stream can be a collection (like List, Set), an array, or I/O channels. methods
    private final EmployeeService employeeService;

    public void stream () {
        List<Employee> employees = employeeService.findAllEmployees();

        Stream.of("-----Find all names starting with letter N-----").forEach(System.out::println);
        //Find all names starting with letter N
        employees.stream().map(employee -> employee.getName()).filter(employee -> employee.startsWith("N")).forEach(System.out::println);

        Stream.of("-----Find all names that have salaries greater than 5CR-----").forEach(System.out::println);

        //Find all names that have salaries greater than 5CR
        employees.stream()
                .filter(employee -> employee.getSalary() > 50000000)
                .map(Employee::getName)
                .forEach(System.out::println);

        Stream.of("-----find all names in decreasing order with age greater than 30-----").forEach(System.out::println);

        //find all names in decreasing order with age greater than 30
        employees.stream().filter(employee -> employee.getAge() > 30).map(Employee::getName).sorted((o1, o2) -> o2.compareTo(o1)).forEach(System.out::println);

        System.out.println("----Another way of handling reverse order----");

        employees.stream().filter(employee -> employee.getAge() > 30).map(Employee::getName).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("----find all names where age is in decreasing order----");

        //find all names where age is in decreasing order
        employees.stream().sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge())).map(employee -> employee.getName()).forEach(System.out::println);

        System.out.println("----find all names where age is in decreasing order and name in increasing order----");

        //find all names where age is in decreasing order and name in increasing order
        List<Employee> listToTake = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed().thenComparing(Employee::getName)).collect(Collectors.toList());
        listToTake.forEach(System.out::println);

        System.out.println("----find all hobbies that are distinct in employees----");

//        find all hobbies that are distinct in employees
        employees.stream().flatMap(employee -> employee.getHobbies().stream()).distinct().forEach(System.out::println);

        System.out.println("----find all hobbies that are distinct in employees and sorted----");

//        find all hobbies that are distinct in employees
        employees.stream().flatMap(employee -> employee.getHobbies().stream()).distinct().sorted().forEach(System.out::println);

        System.out.println("----find all hobbies that are distinct in employees and sorted on the basis of length----");

//        find all hobbies that are distinct in employees
        employees.stream().flatMap(employee -> employee.getHobbies().stream()).distinct().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        System.out.println("----find all hobbies that are distinct in employees and sorted on the basis of length and if the length is equal then lexicographical sorting is pref----");

//        find all hobbies that are distinct in employees and sorted on the basis of length and if the length is equal then lexicographical sorting is pref
        employees.stream().flatMap(employee -> employee.getHobbies().stream()).distinct().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        System.out.println("----find all hobbies that are distinct in employees and sorted on the basis of length and if the length is equal then lexicographical sorting is pref after ignoring the case of two values----");

//        find all hobbies that are distinct in employees and sorted on the basis of length and if the length is equal then lexicographical sorting is pref after ignoring the case of two values, for example: here Foodie and foodie are treated as two diff values but ascii value of f is greater than F so technically F is comes before, hence after putting compareToIgnoreCase it wont affect and sequential order is maintained
        employees.stream().flatMap(employee -> employee.getHobbies().stream()).distinct().sorted(Comparator.comparingInt(String::length).thenComparing((str1, str2) -> str1.compareToIgnoreCase(str2))).forEach(System.out::println);

        System.out.println("----find all addresses that contain vadodara in it----");

        //find all names with addresses that contain vadodara in it
        employees.stream().filter(employee -> employee.getAddress().toLowerCase().contains("vadodara")).map(Employee::getName).forEach(System.out::println);

        System.out.println("----flat address on the basis of space----");

//        flat address on the basis of space
        employees.stream().flatMap(employee -> Arrays.stream(employee.getAddress().split(" "))).distinct().forEach(System.out::println);

        System.out.println("----group employees on the basis of gender----");

//        group employees on the basis of gender
        Map<Boolean, List<Employee>> mapofemployee = employees.stream().collect(Collectors.partitioningBy(t -> t.getGender().equals("F")));
        mapofemployee.forEach((map, employeeList) -> System.out.println("Key: "+ map + " Value: "+ employeeList));

        //        group employees on the basis of gender
        Map<String, List<Employee>> map2ofemployee = employees.stream().collect(Collectors.groupingBy(t -> t.getGender()));
        map2ofemployee.forEach((map, employeeList) -> System.out.println("Key: "+ map + " Value: "+ employeeList));

        //        group employees on the basis of gender whose age is greater than equal to 30
        Map<String, List<Employee>> map3ofemployee = employees.stream().filter(employee -> employee.getAge()>=30).collect(Collectors.groupingBy(t -> t.getGender()));
        map3ofemployee.forEach((map, employeeList) -> System.out.println("Key: "+ map + " Value: "+ employeeList));

        //        count emp on basis of gender and where male emp have only one hobby --left
        Map<String, List<Employee>> map4ofemployee = employees.stream().filter(employee -> employee.getAge()>=30).collect(Collectors.groupingBy(t -> t.getGender()));
        map4ofemployee.forEach((map, employeeList) -> System.out.println("Key: "+ map + " Value: "+ employeeList));

        //        count emp on basis of gender and where male count greater than 2


    }
}
