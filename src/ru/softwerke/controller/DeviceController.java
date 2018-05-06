package ru.softwerke.controller;

import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.service.DeviceService;
import ru.softwerke.model.search.DeviceSearcher;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DeviceController {
    private DeviceService deviceService = DeviceService.getAllDevicesService();


    public void addNewDevice(Long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate) {
        deviceService.addNewDevice(deviceService.getNextDeviceId(), model, manufacturer,
                colour, deviceType, price, productionDate);
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


    public List<DeviceEntity> searchById(Long wantedId) {
        return new DeviceSearcher("id").search(DeviceEntity.createDevice(wantedId, null,
                null, null, null, null, null));
    }

    public List<DeviceEntity> searchByModel(String wantedModel) {
        return new DeviceSearcher("model").search(DeviceEntity.createDevice(null, wantedModel,
                null, null, null, null, null));
    }

    public List<DeviceEntity> searchByManufacturer(String wantedManufacturer) {
        return new DeviceSearcher("manufacturer").search(DeviceEntity.createDevice(null,
                null, wantedManufacturer, null, null, null, null));
    }

    public List<DeviceEntity> searchByColour(String wantedColour) {
        return new DeviceSearcher("colour").search(DeviceEntity.createDevice(null, null,
                null, wantedColour, null, null, null));
    }

    public List<DeviceEntity> searchByDeviceType(String wantedDeviceType) {
        return new DeviceSearcher("type").search(DeviceEntity.createDevice(null, null,
                null, null, wantedDeviceType, null, null));
    }

    public List<DeviceEntity> searchByPrice(BigDecimal wantedPrice) {
        return new DeviceSearcher("price").search(DeviceEntity.createDevice(null, null,
                null, null, null, wantedPrice, null));
    }

    public static List<DeviceEntity> searchByProductionDate(LocalDate wantedProductionDate) {
        return new DeviceSearcher("productionDate").search(DeviceEntity.createDevice(null, null,
                null, null, null, null, wantedProductionDate));
    }

    public List<DeviceEntity> getAllDevicesList() {
        return DeviceService.getAllDevicesList();
    }

    public Long getId() {
        return this.deviceService.getNextDeviceId();
    }


}
