package ru.softwerke.Model.Service;

import ru.softwerke.Model.Class.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ClientService {

    private static ClientService clientService;

    private static List<Client> clientList;

    private ClientService() {
        clientList = new ArrayList<>();
    }



    private long id = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public void addNewClient(long id, String firstName, String lastName, LocalDate birthDate){
        clientList.add(Client.createClient(id, firstName, lastName, birthDate));
        this.id++;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        ClientService.clientList = clientList;
    }

    public static ClientService getClientService() {
        if (clientService == null) {
            clientService = new ClientService();
        }
        return clientService;
    }
}