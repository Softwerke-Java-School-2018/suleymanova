package ru.softwerke.model.utils;

import ru.softwerke.model.service.DeviceService;

import java.math.BigDecimal;
import java.time.LocalDate;


public class StartDevices {
    public void startListOfDevices(){
        DeviceService deviceService = DeviceService.getAllDevicesService();

        deviceService.addNewDevice(deviceService.getNextDeviceId(), "Galaxy S7", "Samsung", "White", "Phone", new BigDecimal("25000.0"), LocalDate.parse("2016-05-05"));
        deviceService.addNewDevice(deviceService.getNextDeviceId(), "K69", "DEXP", "Red", "MP3", new BigDecimal("13540.50"), LocalDate.parse("2017-12-25"));
        deviceService.addNewDevice(deviceService.getNextDeviceId(), "1351", "Dell", "Black", "Laptop", new BigDecimal("1239.50"), LocalDate.parse("2015-11-03"));

    }
}
