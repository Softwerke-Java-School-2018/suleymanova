package ru.softwerke.View;

import java.util.Scanner;

import ru.softwerke.Controller.AddClientController;
import ru.softwerke.Controller.AddDeviceController;
import ru.softwerke.Model.Class.Device;
import ru.softwerke.Model.Service.ClientService;
import ru.softwerke.Model.Class.Client;
import ru.softwerke.Model.Service.DeviseService;

public class Menu {

    public void clientMenuProcessor () {

        Scanner in = new Scanner(System.in);
        ClientService clientService = ClientService.getClientService();
        DeviseService deviseService = DeviseService.getDeviceService();

        System.out.println("Select an action: \n" +
                "1) Add a new Client \n" +
                "2) Add a new Device \n" +
                "3) Show all Clients \n" +
                "4) Show all Devices \n" +
                "5) Show history of sales \n" +
                "6) Make a purchase \n" +
                "7) Find a Device \n" +
                "8) Sort information \n" +
                "0) Exit");

            switch (in.nextInt()) {

                case 1:

                    System.out.println("Print First Name, Last Name and Birth Date (YYYY/MM/DD)");

                    AddClientController addClientController = new AddClientController();
                    addClientController.addPerson();

                    break;

                case 2:

                    System.out.println("Print Model, Manufacturer, Colour, Type, Price and Production Date (YYYY/MM/DD)");

                    AddDeviceController addDeviceController = new AddDeviceController();
                    addDeviceController.addNewDevice();
                    break;


                case 3:

                    for (Client client : clientService.getClientList()) {
                        System.out.println(client.getId() + " " + client.getFirstName() + " "
                                + client.getLastName() + " " + client.getBirthDate());
                    }

                    break;

                case 4:

                    for (Device device : deviseService.getDeviceList()) {
                        System.out.println(device.getId() + " " + device.getModel() + " " + device.getManufacturer() + " "
                                + device.getColour() + " " + device.getDeviceType() + " " + device.getPrice() + " " +
                                device.getProductionDate());
                    }

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
                    break;
                default:
                    System.out.println("Wrong input, try again");
            }

    }
}