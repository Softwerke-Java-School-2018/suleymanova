package ru.softwerke.model.search;

import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientsSearches {
    private static ClientService clientService = ClientService.getAllClientsService();

    private static List<ClientEntity> wantedClientsList;

    public ClientsSearches(){
        wantedClientsList = new ArrayList<>();
    }

    public static List<ClientEntity> searchById(Long wantedId){
        wantedClientsList.clear();
        for (ClientEntity clientEntity : clientService.getAllClientsList()){
            if (clientEntity.getId().equals(wantedId)){
                wantedClientsList.add(clientEntity);
            }
        }
        return wantedClientsList;
    }

    public static List<ClientEntity>  searchByFirstName(String wantedFirstName){
        wantedClientsList.clear();
        for (ClientEntity clientEntity : clientService.getAllClientsList()){
            if (clientEntity.getFirstName().equalsIgnoreCase(wantedFirstName)){
                wantedClientsList.add(clientEntity);
            }
        }
        return wantedClientsList;
    }

    public static List<ClientEntity> searchByLastName(String wantedLastName){
        wantedClientsList.clear();
        for (ClientEntity clientEntity : clientService.getAllClientsList()){
            if (clientEntity.getLastName().equalsIgnoreCase(wantedLastName)){
                wantedClientsList.add(clientEntity);
            }
        }
        return wantedClientsList;
    }

    public static List<ClientEntity>  searchByBirthDate(LocalDate wantedBirthDate){
        wantedClientsList.clear();
        for (ClientEntity clientEntity : clientService.getAllClientsList()){
            if (clientEntity.getBirthDate().equals(wantedBirthDate)){
                wantedClientsList.add(clientEntity);
            }
        }
        return wantedClientsList;
    }

}
