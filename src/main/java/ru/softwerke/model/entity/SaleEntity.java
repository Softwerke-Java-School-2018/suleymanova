package ru.softwerke.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class SaleEntity {
    private String clientName;
    private List<DeviceEntity> listOfPurchasedDevices;
    private LocalDate dateOfSale;
    private BigDecimal amountOfSale;

    private SaleEntity(String clientName, List<DeviceEntity> listOfPurchasedDevices,
                       LocalDate dateOfSale, BigDecimal amountOfSale) {
        this.clientName = clientName;
        this.listOfPurchasedDevices = listOfPurchasedDevices;
        this.dateOfSale = dateOfSale;
        this.amountOfSale = amountOfSale;
    }

    public static SaleEntity addingInHistoryOfSales(String clientName, List<DeviceEntity> listOfPurchasedDevices,
                                                    LocalDate dateOfSale, BigDecimal amountOfSale) {
        return new SaleEntity(clientName, listOfPurchasedDevices, dateOfSale, amountOfSale);
    }

    public String getClientName() {
        return clientName;
    }

    public List<DeviceEntity> getListOfPurchasedDevices() {
        return listOfPurchasedDevices;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public BigDecimal getAmountOfSale() {
        return amountOfSale;
    }

    public void setListOfPurchasedDevices(List<DeviceEntity> listOfPurchasedDevices) {
        this.listOfPurchasedDevices = listOfPurchasedDevices;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public void setAmountOfSale(BigDecimal amountOfSale) {
        this.amountOfSale = amountOfSale;
    }
}
