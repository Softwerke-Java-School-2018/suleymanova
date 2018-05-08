package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChangeInformationView {
    /**
     * Method, which allows change information about existing user.
     *
     * @throws InputMismatchException Thrown by a Scanner to indicate that the token retrieved does not match
     *                                the pattern for the expected type. If user input wrong type, method will
     *                                start again.
     * @throws DateTimeException      This exception is used to indicate problems with creating data-time objects.
     *                                If user input nonexistent year/month/day, method will start again.
     */
    public void change() {
        Scanner scanner = UtilsHelper.getScanner();
        ClientController clientController = new ClientController();


        Long idChangedPerson;
        while (true)
            try {
                System.out.println("Print your id");
                idChangedPerson = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, please try again");
                scanner.next();
            }
        List<ClientEntity> clientList = clientController.searchById(idChangedPerson);
        if (clientList.isEmpty()) {
            System.out.println("We have not person with this id");
        } else {
            System.out.println("What information you want to change?");
            System.out.println("1) First name \n" +
                    "2) Last name \n" +
                    "3) Birth Date");


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
                    while (true)
                        try {
                            System.out.println("Write new Birth Date YYYY/MM/DD");
                            clientList.get(0).setBirthDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input");
                            scanner.next();
                        } catch (DateTimeException e) {
                            System.out.println("Wrong input");
                        }
                    break;
                default:
                    System.out.println("Wrong input");
            }
            System.out.println("\n Final information about Client: " + clientList.get(0).getId() + " " +
                    clientList.get(0).getFirstName() + " " + clientList.get(0).getLastName() + " " +
                    clientList.get(0).getBirthDate());
        }
    }
}