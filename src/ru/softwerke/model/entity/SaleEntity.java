package ru.softwerke.model.entity;

import java.time.LocalDate;
import java.util.List;

public class SaleEntity {
    private String clientName;
    private List<DeviceEntity> listOfPurchasedDevices;
    private LocalDate dateOfSale;


}
