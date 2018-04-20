package ru.softwerke.controller;


import java.util.List;

import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.search.ClientsSearches;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

public class ClientController {
    private static ClientService clientService = ClientService.getAllClientsService();


    public void addPerson(Long id, String firstName, String lastName, LocalDate birthDate) {
        clientService.addNewClient(clientService.getNextClientId(), firstName, lastName, birthDate);

    }



    public void sortById() {
        ClientService.getAllClientsSortedById();
    }


    public void sortByFirstName() {

        ClientService.getAllClientsSortedByFirstName();
    }

    public void sortByLasName() {

        ClientService.getAllClientsSortedByLastName();
    }

    public void sortByBirthDay() {

        ClientService.getAllClientsSortedByBirthDay();
    }

    public List<ClientEntity> searchById(Long wantedId){
        return ClientsSearches.searchById(wantedId);
    }

    public List<ClientEntity> searchByFirstName(String wantedFirstName){
        return ClientsSearches.searchByFirstName(wantedFirstName);
    }

    public List<ClientEntity> searchByLastName(String wantedLastName){
        return ClientsSearches.searchByLastName(wantedLastName);
    }

    public List<ClientEntity> searchByBirthDay(LocalDate wantedBirthDate){
        return ClientsSearches.searchByBirthDate(wantedBirthDate);
    }

    public List<ClientEntity> getAllClientsList() {
        return this.clientService.getAllClientsList();
    }

    public Long getId() {
        return this.clientService.getNextClientId();
    }

}