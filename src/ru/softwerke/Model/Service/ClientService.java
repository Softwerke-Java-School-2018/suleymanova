package ru.softwerke.Model.Service;

import ru.softwerke.Model.Class.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ClientService {

    private static ClientService clientService;

    private static List<Client> clientList;

    private ClientService() {
        clientList = new ArrayList<>();
    }


    private Long id = new Long(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addNewClient(Long id, String firstName, String lastName, LocalDate birthDate) {
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


    private static Comparator<Client> compareById = new Comparator<Client>() {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    private static Comparator<Client> compareByFirstName = new Comparator<Client>() {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        }
    };

    private static Comparator<Client> compareByLastName = new Comparator<Client>() {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getLastName().compareToIgnoreCase(o2.getLastName());
        }
    };

    private static Comparator<Client> compareByBirthDate = new Comparator<Client>() {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getBirthDate().compareTo(o2.getBirthDate());
        }
    };

    public static void comparingById() {
        clientList.sort(compareById);


    }

    public static void comparingByFirstName() {
        clientList.sort(compareByFirstName);

    }

    public static void comparingByLastName() {
        clientList.sort(compareByLastName);

    }

    public static void comparingByBirthDay() {
        clientList.sort(compareByBirthDate);

    }

}