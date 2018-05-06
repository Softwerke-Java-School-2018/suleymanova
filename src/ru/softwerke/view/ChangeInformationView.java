package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ChangeInformationView {
    public void change() {
        Scanner scanner = UtilsHelper.getScanner();
        ClientController clientController = new ClientController();


        System.out.println("Print your id");
        Long idChangedPerson = scanner.nextLong();
        System.out.println("What information you want to change?");
        System.out.println("1) First name \n" +
                "2) Last name \n" +
                "3) Birth Date");
        List<ClientEntity> clientList = clientController.searchById(idChangedPerson);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Write new First Name");
                clientList.get(0).setFirstName(scanner.next());
                break;
            case 2:
                System.out.println("Write new Last Name");
                clientList.get(0).setLastName(scanner.next());
                break;
            case 3:
                System.out.println("Write new Birth Date");
                clientList.get(0).setBirthDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                break;
            default:
                System.out.println("Wrong input");
        }
        System.out.println(clientList.get(0).getId() + " " +
                clientList.get(0).getFirstName() + " " + clientList.get(0).getLastName() + " " +
                clientList.get(0).getBirthDate());
    }
}
