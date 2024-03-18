package org.example.Tools;


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Homework {

    public void printNamesOrdered(List<Streams.Person> persons) {
        persons.stream()
                .map(Streams.Person::getName)
                .sorted()
                .forEach(System.out::println);
    }

    public Map<Streams.Department, Streams.Person> printDepartmentOldestPerson(List<Streams.Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(
                        Streams.Person::getDepartment,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Streams.Person::getAge))
                ));
    }

    public List<Streams.Person> findFirstPersons(List<Streams.Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 30)
                .filter(person -> person.getSalary() > 50_000)
                .limit(10)
                .collect(Collectors.toList());
    }

    public Optional<Streams.Department> findTopDepartment(List<Streams.Person> persons) {
        Map<Streams.Department, Double> totalSalariesByDepartment = persons.stream()
                .collect(Collectors.toMap(
                        Streams.Person::getDepartment,
                        Streams.Person::getSalary,
                        Double::sum
                ));
        return totalSalariesByDepartment.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}