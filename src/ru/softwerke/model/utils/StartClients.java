package ru.softwerke.model.utils;

import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;


public class StartClients {
    public void startListOfClients() {
        ClientService clientService = ClientService.getAllClientsService();

        clientService.addNewClient(clientService.getNextClientId(), "Egor", "Palkin", LocalDate.parse("1997-04-07"));
        clientService.addNewClient(clientService.getNextClientId(), "Iluha", "Pluha", LocalDate.parse("1995-06-23"));
        clientService.addNewClient(clientService.getNextClientId(), "Dashuha", "Prikoluha", LocalDate.parse("1997-07-07"));
        clientService.addNewClient(clientService.getNextClientId(), "Ivan", "Ivanov", LocalDate.parse("1997-07-07"));
        clientService.addNewClient(clientService.getNextClientId(), "Ivan", "NeIvanov", LocalDate.parse("1997-07-07"));
    }
}
