package ru.softwerke.Controller;


import java.util.Scanner;
import ru.softwerke.Model.Service.ClientService;
import java.time.LocalDate;

public class AddClientController {
    ClientService clientService = ClientService.getClientService();



    public ClientService addPerson() {
        Scanner in = new Scanner(System.in);
        clientService.addNewClient(clientService.getId(), in.next(), in.next(),
                LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));
        return (clientService);
    }
}