package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.controller.SaleController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PurchaseView {

    /**
     * Method, which make purchase. User input his id, then id of devices and get amount of purchase.
     *
     * @throws InputMismatchException    Thrown by a Scanner to indicate that the token retrieved does not match
     *                                   the pattern for the expected type. If user input wrong type, method will
     *                                   start again.
     * @throws IndexOutOfBoundsException Thrown to indicate that an index is out of range. If user input nonexistent id,
     *                                   method will start again.
     */
    public void deal() {
        Scanner scanner = UtilsHelper.getScanner();
        ClientController clientController = new ClientController();

        Long idOfPerson;
        while (true)
            try {
                System.out.println("Please, input your id");
                idOfPerson = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, please try again");
                scanner.next();
            }

        List<ClientEntity> checkIdOfPerson = clientController.searchById(idOfPerson);
        if (checkIdOfPerson.isEmpty()) {
            System.out.println("We have not person with this id");
        } else {

            System.out.println(SaleController.setClientBuyer(idOfPerson).toString());

            System.out.println("Please, input id of devices, which you want to buy. If you add all, press -1");

            boolean quitPurchase = false;


            do {
                Long a;
                try {
                    a = scanner.nextLong();
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Wrong input, please, try again.");
                    continue;
                }

                Long idOfDevice = a;
                if (idOfDevice == -1) {
                    quitPurchase = true;
                } else {
                    try {
                        SaleController.setPurchasedDevice(idOfDevice);
                        System.out.println(SaleController.getInformationAboutPurchasedDevices());
                        SaleController.amountOfSale();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Wrong id of Device. Please, try again");
                    }
                }
            } while (!quitPurchase);

            System.out.println("Amount of your purchase is: " + SaleController.getAmountOfAllSale());


            SaleController.addInHistoryOfSales(SaleController.getClientBuyer().toString(),
                    SaleController.getPurchasedDevices(), LocalDate.now(),
                    new BigDecimal(SaleController.getAmountOfAllSale().longValue()));

            SaleController.clearPurchase();
        }
    }
}
