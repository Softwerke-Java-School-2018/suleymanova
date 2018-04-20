package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.controller.DeviceController;
import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.search.ClientsSearches;
import ru.softwerke.model.search.DevicesSearches;
import ru.softwerke.model.service.ClientService;
import ru.softwerke.model.utils.StartClients;
import ru.softwerke.model.utils.StartDevices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void StartClientMenu() {

        Scanner in = new Scanner(System.in);
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();

        StartClients startClients = new StartClients();
        startClients.startListOfClients();

        StartDevices startDevices = new StartDevices();
        startDevices.startListOfDevices();

        ClientsSearches clientsSearches = new ClientsSearches();
        DevicesSearches devicesSearches = new DevicesSearches();

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
                    "-1) Exit \n");

            switch (in.nextInt()) {

                case 1:

                    System.out.println("Print First Name, Last Name and Birth Date (YYYY/MM/DD)");

                    clientController.addPerson(clientController.getId(),
                            in.next(),
                            in.next(),
                            LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));

                    break;

                case 2:

                    System.out.println("Print model, Manufacturer, Colour, Type, Price and Production Date (YYYY/MM/DD)");

                    deviceController.addNewDevice(deviceController.getId(),
                            in.next(), in.next(), in.next(), in.next(),
                            in.nextBigDecimal(), LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));

                    break;


                case 3:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay"));

                    for (ClientEntity clientEntity : clientController.getAllClientsList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                    }
                    System.out.println();

                    break;

                case 4:

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                            "id", "model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));

                    for (DeviceEntity deviceEntity : deviceController.getAllDevicesList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                deviceEntity.getId(), deviceEntity.getModel(), deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                deviceEntity.getDeviceType(), deviceEntity.getPrice(), deviceEntity.getProductionDate()));
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
                            clientController.sortById();

                            break;
                        case 2:
                            clientController.sortByFirstName();

                            break;
                        case 3:
                            clientController.sortByLasName();

                            break;
                        case 4:
                            clientController.sortByBirthDay();

                            break;
                    }
                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay"));

                    for (ClientEntity clientEntity : clientController.getAllClientsList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                    }

                    break;
                case 6:
                    System.out.println("Which parameter devices are sorted? \n" +
                            "1) By id \n" +
                            "2) By model \n" +
                            "3) By Manufacturer \n" +
                            "4) By Colour \n" +
                            "5) By DeviceEntity Type \n" +
                            "6) By Price \n" +
                            "7) By Production Date");

                    switch (in.nextInt()) {
                        case 1:
                            deviceController.sortById();

                            break;
                        case 2:
                            deviceController.sortByModel();

                            break;
                        case 3:
                            deviceController.sortByManufacturer();

                            break;
                        case 4:
                            deviceController.sortByColour();

                            break;
                        case 5:
                            deviceController.sortByDeviceType();

                            break;
                        case 6:
                            deviceController.sortByPrice();

                            break;
                        case 7:
                            deviceController.sortByProductionDate();

                            break;
                        default:
                            System.out.println("Wrong input");

                    }

                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                            "id", "model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));

                    for (DeviceEntity deviceEntity : deviceController.getAllDevicesList()) {
                        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                deviceEntity.getId(), deviceEntity.getModel(), deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                deviceEntity.getDeviceType(), deviceEntity.getPrice(), deviceEntity.getProductionDate()));
                    }

                    System.out.println();
                    break;
                case 7:
                    System.out.println("Which parameter are you need? \n" +
                            "1)Search by Id \n" +
                            "2)Search by First Name \n" +
                            "3)Search by Last Name \n" +
                            "4)Search be Birth Date \n");
                    switch (in.nextInt()) {
                        case 1:
                            System.out.println("Please, input Id");
                            Long wantedId = in.nextLong();
                            List<ClientEntity> wantedClientListID = clientController.searchById(wantedId);
                            if (wantedClientListID.isEmpty()) {
                                System.out.println("There are no client");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                        "id", "FirstName", "LastName", "BirthDay"));
                                for (ClientEntity clientEntity : wantedClientListID) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                            clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Please, input First Name");
                            String wantedFirstName = in.next();
                            List<ClientEntity> wantedClientListFirstName = clientController.searchByFirstName(wantedFirstName);
                            if (wantedClientListFirstName.isEmpty()) {
                                System.out.println("There are no this client");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                        "id", "FirstName", "LastName", "BirthDay"));
                                for (ClientEntity clientEntity : wantedClientListFirstName) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                            clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Please, input Last Name");
                            String wantedLastName = in.next();
                            List<ClientEntity> wantedClientListLastName = clientController.searchByLastName(wantedLastName);
                            if (wantedClientListLastName.isEmpty()) {
                                System.out.println("There are no clients");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                        "id", "FirstName", "LastName", "BirthDay"));
                                for (ClientEntity clientEntity : wantedClientListLastName) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                            clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                                }
                            }

                            break;

                        case 4:
                            System.out.println("Please, input Birth Day");
                            LocalDate wantedBirthDate = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
                            List<ClientEntity> wantedClientListBirthDate = clientController.searchByBirthDay(wantedBirthDate);
                            if (wantedClientListBirthDate.isEmpty()){
                                System.out.println("There are no this clients");
                            }
                            else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                        "id", "FirstName", "LastName", "BirthDay"));
                                for (ClientEntity clientEntity : wantedClientListBirthDate) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$15s",
                                            clientEntity.getId(), clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getBirthDate()));
                                }
                            }

                            break;
                        default:
                            System.out.println("Wrong input");
                    }
                    break;
                case 8:
                    System.out.println("Which parameter are you need? \n" +
                            "1) Find by id \n" +
                            "2) Find by model \n" +
                            "3) Find by Manufacturer \n" +
                            "4) Find by Colour \n" +
                            "5) Find by Device Type \n" +
                            "6) Find by Price \n" +
                            "7) Find by Production Date");
                    switch (in.nextInt()){
                        case 1:
                            System.out.println("Please, input Id");
                            Long wantedId = in.nextLong();
                            List<DeviceEntity> wantedDeviceListID = deviceController.searchById(wantedId);
                            if (wantedDeviceListID.isEmpty()) {
                                System.out.println("There are no device");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListID) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Please, input Model");
                            String wantedModel = in.next();
                            List<DeviceEntity> wantedDeviceListModel = deviceController.searchByModel(wantedModel);
                            if (wantedDeviceListModel.isEmpty()) {
                                System.out.println("There are no devices");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListModel) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Please, input Manufacturer");
                            String wantedManufacturer = in.next();
                            List<DeviceEntity> wantedDeviceListManufacturer = deviceController.searchByManufacturer(wantedManufacturer);
                            if (wantedDeviceListManufacturer.isEmpty()) {
                                System.out.println("There no device");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListManufacturer) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 4:
                            System.out.println("Please, input Colour ");
                            String wantedColour = in.next();
                            List<DeviceEntity> wantedDeviceListColour = deviceController.searchByColour(wantedColour);
                            if (wantedDeviceListColour.isEmpty()) {
                                System.out.println("There are no devices");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListColour) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 5:
                            System.out.println("Please, input Device Type");
                            String wantedDeviceType = in.next();
                            List<DeviceEntity> wantedDeviceListDeviceType = deviceController.searchByDeviceType(wantedDeviceType);
                            if (wantedDeviceListDeviceType.isEmpty()) {
                                System.out.println("There are no devices");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListDeviceType) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 6:
                            System.out.println("Please, input Price");
                            BigDecimal wantedPrice = in.nextBigDecimal();
                            List<DeviceEntity> wantedDeviceListPrice= deviceController.searchByPrice(wantedPrice);
                            if (wantedDeviceListPrice.isEmpty()) {
                                System.out.println("There are no devices");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListPrice) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;

                        case 7:
                            System.out.println("Please, input Production Date ");
                            LocalDate wantedProductionDate = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
                            List<DeviceEntity> wantedDeviceListProductionDate = deviceController.searchByProductionDate(wantedProductionDate);
                            if (wantedDeviceListProductionDate.isEmpty()) {
                                System.out.println("There no device");
                            } else {
                                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                        "id", "model", "Manufacturer", "Colour", "DeviceType",
                                        "Price", "Production Date"));
                                for (DeviceEntity deviceEntity : wantedDeviceListProductionDate) {
                                    System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                                            deviceEntity.getId(), deviceEntity.getModel(),
                                            deviceEntity.getManufacturer(), deviceEntity.getColour(),
                                            deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                                            deviceEntity.getProductionDate()));
                                }
                            }
                            break;
                    }





                    break;
                case 9:
                    System.out.println("Please, input your id");

                    Long idOfPerson = in.nextLong();

                    System.out.println("Please, input id of devices, which you want to buy. If you add all, press -1");

                    boolean quitPurchase = false;

                    do {
                        Long idOfDevice = in.nextLong();
                        if (idOfDevice == -1) {
                            quitPurchase = true;
                        }
                    } while (!quitPurchase);

                    System.out.println();
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