package ru.softwerke.Class;

import java.time.LocalDate;


public class Person {
    long id;
    String firstName;
    String lastName;
    LocalDate birthDate;

    Person (long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


}
