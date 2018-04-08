package ru.softwerke.Class;

import java.math.BigDecimal;
import java.time.LocalDate;
import ru.softwerke.enums.Colour;
import ru.softwerke.enums.DeviceType;

public class Device {
    long id;
    String model;
    String manufacturer;
    Colour deviceCol;
    LocalDate prodDate;
    DeviceType deviceType;
    BigDecimal price;

    Device (long id, String model, String manufacturer, Colour colour, LocalDate prodDate, DeviceType type, BigDecimal price){
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        deviceCol = colour;
        this.prodDate = prodDate;
        deviceType = type;
        this.price = price;
    }
}
