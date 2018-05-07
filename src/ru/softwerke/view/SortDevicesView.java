package ru.softwerke.view;

import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.controller.DeviceController;
import ru.softwerke.model.utils.UtilsHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortDevicesView {
    public void sort() {
        DeviceController deviceController = new DeviceController();

        Scanner scanner = UtilsHelper.getScanner();

        while (true)
            try {
                System.out.println("Which parameter devices should be sorted? \n" +
                        "1) By id \n" +
                        "2) By model \n" +
                        "3) By Manufacturer \n" +
                        "4) By Colour \n" +
                        "5) By Device Type \n" +
                        "6) By Price \n" +
                        "7) By Production Date");

                switch (scanner.nextInt()) {
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
                        System.out.println("Wrong input. Please, try again");
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please, try again.");
                scanner.next();
            }

        System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                "id", "model", "Manufacturer", "Colour", "DeviceType", "Price", "Production Date"));

        for (DeviceEntity deviceEntity : deviceController.getAllDevicesList()) {
            System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                    deviceEntity.getId(), deviceEntity.getModel(), deviceEntity.getManufacturer(), deviceEntity.getColour(),
                    deviceEntity.getDeviceType(), deviceEntity.getPrice(), deviceEntity.getProductionDate()));
        }

        System.out.println();
    }
}
