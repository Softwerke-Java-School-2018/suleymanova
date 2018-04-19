package ru.softwerke.Controller;


import java.util.List;
import java.util.Scanner;

import ru.softwerke.Model.Class.Client;
import ru.softwerke.Model.Service.ClientService;

import java.time.LocalDate;

public class ClientController {
    private ClientService clientService = ClientService.getClientService();


    public void addPerson() {
        Scanner in = new Scanner(System.in);
        clientService.addNewClient(clientService.getId(), in.next(), in.next(),
                LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));
    }

    public List<Client> getClientsListC() {
        return this.clientService.getClientList();
    }

    public Long getIdC() {
        return this.clientService.getId();
    }

    public void sortingById() {
        ClientService.comparingById();
    }


    public void sortingByFirstName() {

        ClientService.comparingByFirstName();
    }

    public void sortingByLasName() {

        ClientService.comparingByLastName();
    }

    public void sortingByBirthDay() {

        ClientService.comparingByBirthDay();
    }

}