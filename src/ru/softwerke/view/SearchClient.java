package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SearchClient {

    public void search() {
        ClientController clientController = new ClientController();
        Scanner scanner = UtilsHelper.getScanner();
        System.out.println("By which parameter to look for the client? \n" +
                "1)Search by Id \n" +
                "2)Search by First Name \n" +
                "3)Search by Last Name \n" +
                "4)Search by Birth Date \n");


        List<ClientEntity> wantedClientList = null;
        switch (scanner.nextInt()) {
            case 1:

                System.out.println("Please, input Id");
                Long wantedId = scanner.nextLong();
                wantedClientList = clientController.searchById(wantedId);

                break;

            case 2:
                System.out.println("Please, input First Name");
                String wantedFirstName = scanner.next();
                wantedClientList = clientController.searchByFirstName(wantedFirstName);

                break;

            case 3:
                System.out.println("Please, input Last Name");
                String wantedLastName = scanner.next();
                wantedClientList = clientController.searchByLastName(wantedLastName);

                break;

            case 4:
                System.out.println("Please, input Birth Day");
                LocalDate wantedBirthDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                wantedClientList = clientController.searchByBirthDay(wantedBirthDate);

                break;

        }


        try {
            if (wantedClientList.isEmpty()) {
            }
            System.out.println(ConstantsForOutput.MENU_CLIENTS);
            for (ClientEntity clientEntity : wantedClientList) {
                System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                        clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
            }
        } catch (NullPointerException e) {
            System.out.println("Wrong input");
        }


    }
}
