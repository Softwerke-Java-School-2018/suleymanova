package ru.softwerke.model.entity;

import java.time.LocalDate;


public class ClientEntity {


    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    ClientEntity(Long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public static ClientEntity createClient(Long id, String firstName, String lastName, LocalDate birthDate) {
        return new ClientEntity(id, firstName, lastName, birthDate);
    }


    @Override
    public String toString() {
        return (id + " " + firstName + " " + lastName + " " + birthDate);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

