package ru.softwerke.model.service;

import ru.softwerke.model.entity.ClientEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ClientService {

    private static ClientService clientService;

    private static List<ClientEntity> clientList = new ArrayList<>();

/*    public ClientService() {
        clientList = new ArrayList<>();
    }*/


    private Long nextClientId = 1L;


    public void addNewClient(Long id, String firstName, String lastName, LocalDate birthDate) {
        clientList.add(ClientEntity.createClient(nextClientId, firstName, lastName, birthDate));
        this.nextClientId++;
    }


    private static Comparator<ClientEntity> compareById = (o1, o2) ->
            o1.getId().compareTo(o2.getId());

    private static Comparator<ClientEntity> compareByFirstName = (o1, o2) ->
            o1.getFirstName().compareToIgnoreCase(o2.getFirstName());

    private static Comparator<ClientEntity> compareByLastName = (o1, o2) ->
            o1.getLastName().compareToIgnoreCase(o2.getLastName());

    private static Comparator<ClientEntity> compareByBirthDate = (o1, o2) ->
            o1.getBirthDate().compareTo(o2.getBirthDate());


    public List<ClientEntity> getAllClientsList() {
        return clientList;
    }

    public static void getAllClientsSortedById() {
        clientList.sort(compareById);


    }

    public static void getAllClientsSortedByFirstName() {
        clientList.sort(compareByFirstName);

    }

    public static void getAllClientsSortedByLastName() {
        clientList.sort(compareByLastName);

    }

    public static void getAllClientsSortedByBirthDay() {
        clientList.sort(compareByBirthDate);

    }

    public Long getNextClientId() {
        return nextClientId;
    }


    public static ClientService getAllClientsService() {
        if (clientService == null) {
            clientService = new ClientService();
        }
        return clientService;
    }

    private int indexForDelete;

    public void deleteClient(Long idOfClient) {
        for (ClientEntity clientEntity : clientService.getAllClientsList()) {
            if (clientEntity.getId().equals(idOfClient)) {
                indexForDelete = clientList.indexOf(clientEntity);
            }
        }
        clientList.remove(indexForDelete);
    }

}