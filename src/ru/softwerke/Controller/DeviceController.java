package ru.softwerke.Controller;

import ru.softwerke.Model.Class.Device;
import ru.softwerke.Model.Service.DeviceService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DeviceController {
    private DeviceService deviceService = DeviceService.getDeviceService();


    public void addNewDevice() {
        Scanner in = new Scanner(System.in);
        deviceService.addNewDevice(deviceService.getId(), in.next(), in.next(), in.next(), in.next(),
                in.nextBigDecimal(), LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));

    }

    public List<Device> getDeviceListC() {
        return DeviceService.getDeviceList();
    }

    public void sortingById() {

        DeviceService.comparingById();
    }

    public void sortingByModel() {

        DeviceService.comparingByModel();
    }

    public void sortingByManufacturer() {

        DeviceService.comparingByManufacturer();
    }

    public void sortingByColour() {

        DeviceService.comparingByColour();
    }

    public void sortingByDeviceType() {

        DeviceService.comparingByDeviceType();
    }

    public void sortingByPrice() {

        DeviceService.comparingByPrice();
    }

    public void sortingByProductionDate() {

        DeviceService.comparingByProductionDate();
    }
}
