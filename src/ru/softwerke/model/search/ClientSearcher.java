package ru.softwerke.model.search;

import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.search.SearchClient;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class ClientSearcher implements SearchClient {

    private BiPredicate<ClientEntity, ClientEntity> isClientMatchesPredicate;

    private static ClientService clientService = ClientService.getAllClientsService();

    private static List<ClientEntity> wantedClientsList;

    public ClientSearcher() {
        wantedClientsList = new ArrayList<>();
    }

    public ClientSearcher(String fieldName) {
        switch (fieldName) {
            case "lastName":
                isClientMatchesPredicate = (c1, c2) -> {
                    return (c1.getLastName().equalsIgnoreCase(c2.getLastName()));
                };
                break;
            case "firstName":
                isClientMatchesPredicate = (c1, c2) -> {
                    return (c1.getFirstName().equalsIgnoreCase(c2.getFirstName()));
                };
                break;
            case "id":
                isClientMatchesPredicate = (c1, c2) -> {
                    return c1.getId().equals(c2.getId());
                };
                break;
            case "birthDate":
                isClientMatchesPredicate = (c1, c2) -> {
                    return c1.getBirthDate().equals(c2.getBirthDate());
                };
                break;
            default:
                System.out.println("DASHA POMENYAI");
        }
        wantedClientsList = new ArrayList<>();
    }

    @Override
    public List<ClientEntity> search(ClientEntity client) {
        wantedClientsList.clear();
        for (ClientEntity clientEntity : clientService.getAllClientsList()) {
            if (isClientMatchesPredicate.test(client, clientEntity)) {
                wantedClientsList.add(clientEntity);
            }
        }
        return wantedClientsList;
    }

}