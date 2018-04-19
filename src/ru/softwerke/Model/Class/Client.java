package ru.softwerke.Model.Class;

import java.time.LocalDate;


public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private Client(Long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public static Client createClient(Long id, String firstName, String lastName, LocalDate birthDate) {
        return new Client(id, firstName, lastName, birthDate);
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


}

