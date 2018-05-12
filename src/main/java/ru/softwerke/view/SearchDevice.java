package ru.softwerke.view;

import ru.softwerke.controller.DeviceController;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.utils.UtilsHelper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SearchDevice {
    public void search() {
        DeviceController deviceController = new DeviceController();
        Scanner scanner = UtilsHelper.getScanner();
        System.out.println("By which parameter to look for the client? \n" +
                "1) Find by id \n" +
                "2) Find by model \n" +
                "3) Find by Manufacturer \n" +
                "4) Find by Colour \n" +
                "5) Find by Device Type \n" +
                "6) Find by Price \n" +
                "7) Find by Production Date");
        List<DeviceEntity> wantedDeviceList = null;
        switch (scanner.nextInt()) {

            case 1:
                System.out.println("Please, input Id");
                Long wantedId = scanner.nextLong();
                wantedDeviceList = deviceController.searchById(wantedId);

                break;

            case 2:
                System.out.println("Please, input Model");
                String wantedModel = scanner.next();
                wantedDeviceList = deviceController.searchByModel(wantedModel);
                break;

            case 3:
                System.out.println("Please, input Manufacturer");
                String wantedManufacturer = scanner.next();
                wantedDeviceList = deviceController.searchByManufacturer(wantedManufacturer);
                break;

            case 4:
                System.out.println("Please, input Colour ");
                String wantedColour = scanner.next();
                wantedDeviceList = deviceController.searchByColour(wantedColour);
                break;

            case 5:
                System.out.println("Please, input Device Type");
                String wantedDeviceType = scanner.next();
                wantedDeviceList = deviceController.searchByDeviceType(wantedDeviceType);
                break;

            case 6:
                System.out.println("Please, input Price");
                BigDecimal wantedPrice = scanner.nextBigDecimal();
                wantedDeviceList = deviceController.searchByPrice(wantedPrice);

                break;

            case 7:
                System.out.println("Please, input Production Date ");
                LocalDate wantedProductionDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                wantedDeviceList = DeviceController.searchByProductionDate(wantedProductionDate);
                break;
        }

        try{
        if (wantedDeviceList.isEmpty()) {
        }
            System.out.println(ConstantsForOutput.MENU_DEVICES);
            for (DeviceEntity deviceEntity : wantedDeviceList) {
                System.out.println(String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
                        deviceEntity.getId(), deviceEntity.getModel(),
                        deviceEntity.getManufacturer(), deviceEntity.getColour(),
                        deviceEntity.getDeviceType(), deviceEntity.getPrice(),
                        deviceEntity.getProductionDate()));
            }
        } catch (NullPointerException e){
            System.out.println("Wrong input");
        }
    }
}
