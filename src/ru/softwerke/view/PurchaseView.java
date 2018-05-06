package ru.softwerke.view;

import ru.softwerke.controller.SaleController;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.service.DeviceService;
import ru.softwerke.model.utils.UtilsHelper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseView {
    public void deal() {
        Scanner scanner = UtilsHelper.getScanner();

        System.out.println("Please, input your id");

        Long idOfPerson = scanner.nextLong();


        System.out.println(SaleController.getClientBuyer(idOfPerson).toString());

        System.out.println("Please, input id of devices, which you want to buy. If you add all, press -1");

        boolean quitPurchase = false;

        do {
            Long idOfDevice = scanner.nextLong();
            if (idOfDevice == -1) {
                quitPurchase = true;
            } else {
                SaleController.setPurchasedDevice(idOfDevice);
                System.out.println(SaleController.getInformationAboutPurchasedDevices());
                SaleController.amountOfSale();

            }
        } while (!quitPurchase);

        System.out.println("Amount of your purchase is: " + SaleController.getAmountOfAllSale());


        SaleController.addInHistoryOfSales(SaleController.getClientBuyer(idOfPerson).toString(),
                SaleController.getPurchasedDevices(), LocalDate.now(),
                new BigDecimal(SaleController.getAmountOfAllSale().longValue()));

        SaleController.clearPurchase();
    }
}
