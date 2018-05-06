package ru.softwerke.controller;

import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.entity.SaleEntity;
import ru.softwerke.model.service.SaleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleController {

    SaleService saleService = new SaleService();

    public static List<ClientEntity> getClientBuyer(Long buyerId) {
        return SaleService.getClientBuyer(buyerId);
    }

    public static void setPurchasedDevice(Long idOfDevice) {
        SaleService.setPurchasedDevice(idOfDevice);
    }

    public static String getInformationAboutPurchasedDevices() {
        return SaleService.getInformationAboutPurchasedDevices();
    }

    public static void amountOfSale() {
        SaleService.amountOfSale();
    }

    public static BigDecimal getAmountOfAllSale() {
        return SaleService.getAmountOfAllSale();
    }

    public static void addInHistoryOfSales(String clientName, List<DeviceEntity> listOfPurchasedDevices,
                                           LocalDate dateOfSale, BigDecimal amountOfSale) {
        SaleService.addInHistoryOfSales(clientName, listOfPurchasedDevices, dateOfSale, amountOfSale);
    }

    public static void clearPurchase() {
        SaleService.clearPurchase();
    }

    public static List<DeviceEntity> getPurchasedDevices() {
        return SaleService.getPurchasedDevices();
    }

    public static List<SaleEntity> getHistoryOfSales() {
        return SaleService.getHistoryOfSales();
    }
}
