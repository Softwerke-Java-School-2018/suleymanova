package ru.softwerke.controller;

import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.search.DevicesSearches;
import ru.softwerke.model.service.DeviceService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DeviceController {
    private DeviceService deviceService = DeviceService.getAllDevicesService();


    public void addNewDevice(Long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate) {
        Scanner in = new Scanner(System.in);
        deviceService.addNewDevice(deviceService.getNextDeviceId(), model, manufacturer, colour, deviceType, price, productionDate);
    }

    public void sortById() {

        DeviceService.getAllDevicesSortedById();
    }

    public void sortByModel() {

        DeviceService.getAllDevicesSortedByModel();
    }

    public void sortByManufacturer() {

        DeviceService.getAllDevicesSortedByManufacturer();
    }

    public void sortByColour() {

        DeviceService.getAllDevicesSortedByColour();
    }

    public void sortByDeviceType() {

        DeviceService.getAllDevicesSortedByDeviceType();
    }

    public void sortByPrice() {

        DeviceService.getAllDevicesSortedByPrice();
    }

    public void sortByProductionDate() {

        DeviceService.getAllDevicesSortedByProductionDate();
    }


    public List<DeviceEntity> searchById(Long wantedId){
        return DevicesSearches.searchById(wantedId);
    }

    public List<DeviceEntity> searchByModel(String wantedModel){
        return DevicesSearches.searchByModel(wantedModel);
    }

    public  List<DeviceEntity> searchByManufacturer(String wantedManufacturer){
        return DevicesSearches.searchByManufacturer(wantedManufacturer);
    }

    public List<DeviceEntity> searchByColour(String wantedColour){
        return DevicesSearches.searchByColour(wantedColour);
    }

    public List<DeviceEntity> searchByDeviceType(String wantedDeviceType){
        return DevicesSearches.searchDeviceType(wantedDeviceType);
    }

    public List<DeviceEntity> searchByPrice(BigDecimal wantedPrice){
        return DevicesSearches.searchByPrice(wantedPrice);
    }

    public static List<DeviceEntity> searchByProductionDate(LocalDate wantedProductionDate){
        return DevicesSearches.searchByProductionDate(wantedProductionDate);
    }

    public List<DeviceEntity> getAllDevicesList() {
        return DeviceService.getAllDevicesList();
    }
    public Long getId() {
        return this.deviceService.getNextDeviceId();
    }


}
