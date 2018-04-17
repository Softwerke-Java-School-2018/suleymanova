package ru.softwerke.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ru.softwerke.Controller.AddClientController;
import ru.softwerke.Controller.AddDeviceController;
import ru.softwerke.Model.Class.Device;
import ru.softwerke.Model.Service.ClientService;
import ru.softwerke.Model.Class.Client;
import ru.softwerke.Model.Service.DeviceService;

public class Menu {

    public void clientMenuProcessor () {

        Scanner in = new Scanner(System.in);
        ClientService clientService = ClientService.getClientService();
        DeviceService deviceService = DeviceService.getDeviceService();
        AddClientController addClientController = new AddClientController();
        AddDeviceController addDeviceController = new AddDeviceController();

        clientService.addNewClient(clientService.getId(), "Egor", "Palkin", LocalDate.parse("1997-04-07"));
        clientService.addNewClient(clientService.getId(), "Iluha", "Pluha", LocalDate.parse("1995-06-23"));
        clientService.addNewClient(clientService.getId(), "Dashuha", "Prikoluha", LocalDate.parse("1997-07-07"));

        deviceService.addNewDevice(deviceService.getId(), "Galaxy S7", "Samsung", "White", "Phone", new BigDecimal("25000.0"), LocalDate.parse("2016-05-05"));
        deviceService.addNewDevice(deviceService.getId(), "K69", "DEXP", "Red", "MP3", new BigDecimal("1239.50"), LocalDate.parse("2017-12-25"));
        deviceService.addNewDevice(deviceService.getId(), "1351", "Dell", "Black", "Laptop", new BigDecimal("1239.50"), LocalDate.parse("2015-11-03"));

        boolean quit = false;

        do {
            System.out.println("Select an action: \n" +
                    "1) Add a new Client \n" +
                    "2) Add a new Device \n" +
                    "3) Show all Clients \n" +
                    "4) Show all Devices \n" +
                    "5) Show history of sales \n" +
                    "6) Make a purchase \n" +
                    "7) Find a Device \n" +
                    "8) Sort information \n" +
                    "0) Exit \n");

            switch (in.nextInt()) {

                case 1:

                    System.out.println("Print First Name, Last Name and Birth Date (YYYY/MM/DD)");
                    addClientController.addPerson();

                    break;

                case 2:

                    System.out.println("Print Model, Manufacturer, Colour, Type, Price and Production Date (YYYY/MM/DD)");
                    addDeviceController.addNewDevice();

                    break;


                case 3:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay") );
                    for (Client client : clientService.getClientList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                client.getId(), client.getFirstName(), client.getLastName(), client.getBirthDate())) ;
                    }
                    System.out.println();

                    break;

                case 4:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                            "id", "Model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));

                    for (Device device : deviceService.getDeviceList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                device.getId(), device.getModel(), device.getManufacturer(), device.getColour(),
                                device.getDeviceType(), device.getPrice(), device.getProductionDate()));
                    }
                    System.out.println();


                    break;

                case 5:
                    break;
                case 6:
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