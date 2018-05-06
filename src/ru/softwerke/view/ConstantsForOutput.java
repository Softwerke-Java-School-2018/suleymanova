package ru.softwerke.view;


public class ConstantsForOutput {

    public static final String MENU_CLIENTS = String.format("%1$2s %2$10s %3$15s %4$15s",
                            "id", "FirstName", "LastName", "BirthDay");

    public static final String MENU_DEVICES = String.format("%1$2s %2$10s %3$15s %4$10s %5$15s %6$10s %7$20s",
            "id", "model", "Manufacturer", "Colour", "DeviceType",
            "Price", "Production Date");


}
