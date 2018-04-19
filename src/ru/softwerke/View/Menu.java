package ru.softwerke.View;

import ru.softwerke.Controller.ClientController;
import ru.softwerke.Controller.DeviceController;
import ru.softwerke.Model.Class.Client;
import ru.softwerke.Model.Class.Device;
import ru.softwerke.Model.Service.ClientService;
import ru.softwerke.Model.Service.DeviceService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public void processingOfClientMenu() {

        Scanner in = new Scanner(System.in);
        ClientService clientService = ClientService.getClientService();
        DeviceService deviceService = DeviceService.getDeviceService();
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();

        clientService.addNewClient(clientService.getId(), "Egor", "Palkin", LocalDate.parse("1997-04-07"));
        clientService.addNewClient(clientService.getId(), "Iluha", "Pluha", LocalDate.parse("1995-06-23"));
        clientService.addNewClient(clientService.getId(), "Dashuha", "Prikoluha", LocalDate.parse("1997-07-07"));

        deviceService.addNewDevice(deviceService.getId(), "Galaxy S7", "Samsung", "White", "Phone", new BigDecimal("25000.0"), LocalDate.parse("2016-05-05"));
        deviceService.addNewDevice(deviceService.getId(), "K69", "DEXP", "Red", "MP3", new BigDecimal("13540.50"), LocalDate.parse("2017-12-25"));
        deviceService.addNewDevice(deviceService.getId(), "1351", "Dell", "Black", "Laptop", new BigDecimal("1239.50"), LocalDate.parse("2015-11-03"));

        boolean quit = false;

        do {
            System.out.println("Select an action: \n" +
                    "1) Add a new Client \n" +
                    "2) Add a new Device \n" +
                    "3) Show all Clients \n" +
                    "4) Show all Devices \n" +
                    "5) Sort Clients information \n" +
                    "6) Sort Device information \n" +
                    "7) Find a Device  \n" +
                    "8) Make a purchase  \n" +
                    "9) Show history of sales \n" +
                    "0) Exit \n");

            switch (in.nextInt()) {

                case 1:

                    System.out.println("Print First Name, Last Name and Birth Date (YYYY/MM/DD)");
                    clientController.addPerson();

                    break;

                case 2:

                    System.out.println("Print Model, Manufacturer, Colour, Type, Price and Production Date (YYYY/MM/DD)");
                    deviceController.addNewDevice();

                    break;


                case 3:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay"));
                    for (Client client : clientController.getClientsListC()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                client.getId(), client.getFirstName(), client.getLastName(), client.getBirthDate()));
                    }
                    System.out.println();

                    break;

                case 4:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                            "id", "Model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));

                    for (Device device : deviceController.getDeviceListC()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                device.getId(), device.getModel(), device.getManufacturer(), device.getColour(),
                                device.getDeviceType(), device.getPrice(), device.getProductionDate()));
                    }
                    System.out.println();


                    break;

                case 5:
                    System.out.println("Which parameter clients are sorted? \n" +
                            "1) By id \n" +
                            "2) By First Name \n" +
                            "3) By Last Name \n" +
                            "4) By Birth Date");
                    switch (in.nextInt()) {
                        case 1:
                            clientController.sortingById();

                            break;
                        case 2:
                            clientController.sortingByFirstName();

                            break;
                        case 3:
                            clientController.sortingByLasName();

                            break;
                        case 4:
                            clientController.sortingByBirthDay();

                            break;
                    }
                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay"));
                    for (Client client : clientController.getClientsListC()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                client.getId(), client.getFirstName(), client.getLastName(), client.getBirthDate()));
                    }

                    break;
                case 6:
                    System.out.println("Which parameter devices are sorted? \n" +
                            "1) By id \n" +
                            "2) By Model \n" +
                            "3) By Manufacterer \n" +
                            "4) By Colour \n" +
                            "5) By Device Type \n" +
                            "6) By Price \n" +
                            "7) By Production Date");
                    switch (in.nextInt()) {
                        case 1:
                            deviceController.sortingById();

                            break;
                        case 2:
                            deviceController.sortingByModel();

                            break;
                        case 3:
                            deviceController.sortingByManufacturer();

                            break;
                        case 4:
                            deviceController.sortingByColour();

                            break;
                        case 5:
                            deviceController.sortingByDeviceType();

                            break;
                        case 6:
                            deviceController.sortingByPrice();

                            break;
                        case 7:
                            deviceController.sortingByProductionDate();

                            break;

                    }
                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                            "id", "Model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));
                    for (Device device : deviceController.getDeviceListC()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                device.getId(), device.getModel(), device.getManufacturer(), device.getColour(),
                                device.getDeviceType(), device.getPrice(), device.getProductionDate()));
                    }
                    System.out.println();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong input, try again");
            }
        } while (!quit);

    }
}