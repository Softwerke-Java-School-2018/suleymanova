package ru.softwerke.Controller;


import java.util.Scanner;
import ru.softwerke.Model.Service.ClientService;
import java.time.LocalDate;

public class AddClientController {
    ClientService clientService = ClientService.getClientService();
    long id = 0;

    public ClientService addPerson() {
        Scanner in = new Scanner(System.in);
        clientService.addNewClient(id, in.next(), in.next(),
                LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));
        id++;
        return (clientService);
    }
}