package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortClientView {

    /**
     * Method make sort Clients by selected parameter.
     *
     * @throws InputMismatchException Thrown by a Scanner to indicate that the token retrieved does not match
     *                                the pattern for the expected type. If user input wrong type, method will
     *                                start again.
     */
    public void sort() {
        ClientController clientController = new ClientController();
        Scanner scanner = UtilsHelper.getScanner();

        while (true)
            try {
                System.out.println("Which parameter clients should be sorted? \n" +
                        "1) By id \n" +
                        "2) By First Name \n" +
                        "3) By Last Name \n" +
                        "4) By Birth Date");

                switch (scanner.nextInt()) {

                    case 1:
                        clientController.sortById();

                        break;
                    case 2:
                        clientController.sortByFirstName();

                        break;
                    case 3:
                        clientController.sortByLastName();

                        break;
                    case 4:
                        clientController.sortByBirthDay();

                        break;
                    default:
                        System.out.println("Wrong input. Please, try again");
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please, try again.");
                scanner.next();
            }


        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                "id", "FirstName", "LastName", "BirthDay"));

        for (ClientEntity clientEntity : clientController.getAllClientsList()) {
            System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                    clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(),
                    clientEntity.getBirthDate()));
        }

    }
}