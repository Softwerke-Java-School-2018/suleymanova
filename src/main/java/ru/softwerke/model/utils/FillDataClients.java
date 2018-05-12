package ru.softwerke.model.utils;

import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;


public class FillDataClients {
    public void startListOfClients() {
        ClientService clientService = ClientService.getAllClientsService();


        clientService.addNewClient(clientService.getNextClientId(), "Egor",
                "Palkin", LocalDate.parse("1997-04-07"));

        clientService.addNewClient(clientService.getNextClientId(), "Ilya",
                "Fedorov", LocalDate.parse("1996-06-23"));

        clientService.addNewClient(clientService.getNextClientId(), "Dasha",
                "Suleymanova", LocalDate.parse("1997-07-07"));

        clientService.addNewClient(clientService.getNextClientId(), "Ivan",
                "Ivanov", LocalDate.parse("1997-07-07"));

        clientService.addNewClient(clientService.getNextClientId(), "Ivan",
                "Panov", LocalDate.parse("1995-12-07"));
    }
}
