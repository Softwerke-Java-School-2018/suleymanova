package ru.softwerke.view;

import ru.softwerke.controller.*;
import ru.softwerke.model.entity.*;
import ru.softwerke.model.utils.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public void startClientMenu() {

        Scanner scanner = UtilsHelper.getScanner();

        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();

        SortClientView sortClientView = new SortClientView();
        SortDevicesView sortDevicesView = new SortDevicesView();

        SearchClient searchClient = new SearchClient();
        SearchDevice searchDevice = new SearchDevice();
        PurchaseView purchaseView = new PurchaseView();
        ChangeInformationView changeInformationView = new ChangeInformationView();

        FillDataClients fillDataClients = new FillDataClients();
        fillDataClients.startListOfClients();
        FillDataDevices fillDataDevices = new FillDataDevices();
        fillDataDevices.startListOfDevices();

        boolean quit = false;

        do {
            System.out.println("Select an action: \n" +
                    "1) Add a new Client \n" +
                    "2) Add a new Device \n" +
                    "3) Show all Clients \n" +
                    "4) Show all Devices \n" +
                    "5) Sort Clients information \n" +
                    "6) Sort Device information \n" +
                    "7) Find a Client \n" +
                    "8) Find a Device \n" +
                    "9) Make a purchase  \n" +
                    "10) Show history of sales \n" +
                    "11) Change Client Information \n" +
                    "12) Delete Client \n" +
                    "-1) Exit \n");

            switch (scanner.nextInt()) {

                case 1:

                    System.out.println("Print First Name, Last Name and Birth Date (YYYY/MM/DD)");
                    clientController.addPerson(clientController.getId(), scanner.next(), scanner.next(),
                            LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                    break;

                case 2:

                    System.out.println("Print model, Manufacturer, Colour, Type, Price and Production Date (YYYY/MM/DD)");
                    deviceController.addNewDevice(deviceController.getId(), scanner.next(), scanner.next(),
                            scanner.next(), scanner.next(), scanner.nextBigDecimal(), LocalDate.of(scanner.nextInt(),
                                    scanner.nextInt(), scanner.nextInt()));
                    break;


                case 3:

                    System.out.println(ConstantsForOutput.MENU_CLIENTS);
                    for (ClientEntity clientEntity : clientController.getAllClientsList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(),
                                clientEntity.getBirthDate()));
                    }
                    break;

                case 4:

                    System.out.println(ConstantsForOutput.MENU_DEVICES);
                    for (DeviceEntity deviceEntity : deviceController.getAllDevicesList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                deviceEntity.getId(), deviceEntity.getModel(), deviceEntity.getManufacturer(),
                                deviceEntity.getColour(), deviceEntity.getDeviceType(),
                                deviceEntity.getPrice(), deviceEntity.getProductionDate()));
                    }
                    break;

                case 5:
                    sortClientView.sort();
                    break;

                case 6:
                    sortDevicesView.sort();
                    break;

                case 7:
                    searchClient.search();
                    break;

                case 8:
                    searchDevice.search();
                    break;

                case 9:
                    purchaseView.deal();
                    break;

                case 10:

                    for (SaleEntity saleEntity : SaleController.getHistoryOfSales()) {
                        System.out.println(saleEntity.getClientName() + " " + saleEntity.getListOfPurchasedDevices() +
                                " " + saleEntity.getDateOfSale() + " " + saleEntity.getAmountOfSale());
                    }
                    break;

                case 11:
                    changeInformationView.change();
                    break;

                case 12:
                    System.out.println("Print id of Client");
                    ClientController.deleteClient(scanner.nextLong());
                    break;

                case -1:
                    quit = true;
                    break;

                default:
                    System.out.println("Wrong input, try again");
            }
        } while (!quit);
    }
}