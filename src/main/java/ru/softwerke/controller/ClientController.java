package ru.softwerke.controller;


import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.search.ClientSearcher;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;
import java.util.List;

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

    public void sortByLastName() {

        ClientService.getAllClientsSortedByLastName();
    }

    public void sortByBirthDay() {

        ClientService.getAllClientsSortedByBirthDay();
    }

    public List<ClientEntity> searchById(Long wantedId) {
        return new ClientSearcher("id").search(ClientEntity.createClient(wantedId, null,
                null, null));
    }

    public List<ClientEntity> searchByFirstName(String wantedFirstName) {
        return new ClientSearcher("firstName").search(ClientEntity.createClient(null, wantedFirstName,
                null, null));
    }

    public List<ClientEntity> searchByLastName(String wantedLastName) {
        //return ClientsSearches.searchByLastName(wantedLastName);
        return new ClientSearcher("lastName").search(ClientEntity.createClient(null, null,
                wantedLastName, null));
    }

    public List<ClientEntity> searchByBirthDay(LocalDate wantedBirthDate) {
        return new ClientSearcher("birthDate").search(ClientEntity.createClient(null, null,
                null, wantedBirthDate));
    }

    public static void deleteClient(Long idOfClient) {
        clientService.deleteClient(idOfClient);
    }

    public List<ClientEntity> getAllClientsList() {
        return this.clientService.getAllClientsList();
    }

    public Long getId() {
        return this.clientService.getNextClientId();
    }

}