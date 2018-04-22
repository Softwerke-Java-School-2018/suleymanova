package ru.softwerke.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;


public class DeviceEntity {
    private Long id;
    private String model;
    private String manufacturer;
    private String colour;
    private String deviceType;
    private BigDecimal price;
    private LocalDate productionDate;

    private DeviceEntity(Long id, String model, String manufacturer, String colour, String deviceType,
                         BigDecimal price, LocalDate productionDate) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.colour = colour;
        this.productionDate = productionDate;
        this.deviceType = deviceType;
        this.price = price;
    }

    public static DeviceEntity createDevice(Long id, String model, String manufacturer, String colour, String deviceType,
                                            BigDecimal price, LocalDate productionDate) {
        return new DeviceEntity(id, model, manufacturer, colour, deviceType, price, productionDate);
    }

    @Override
    public String toString() {
        return ("" + deviceType + " " + manufacturer + " " + model);
    }

    public Long getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColour() {
        return colour;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setProductionDate(String prodDate) {
        this.productionDate = LocalDate.parse(prodDate);
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }


}
