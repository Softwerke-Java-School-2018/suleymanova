package ru.softwerke.model.service;

import ru.softwerke.model.entity.DeviceEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeviceService {
    private static DeviceService deviceService;


    private static List<DeviceEntity> deviceList;

    private DeviceService() {
        deviceList = new ArrayList<>();
    }

    private Long nextDeviceId = 1L;


    public void addNewDevice(Long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate) {
        deviceList.add(DeviceEntity.createDevice(nextDeviceId, model, manufacturer, colour, deviceType, price, productionDate));
        this.nextDeviceId++;
    }


    private static Comparator<DeviceEntity> compareById = (o1, o2) -> o1.getId().compareTo(o2.getId());

    private static Comparator<DeviceEntity> compareByModel = (o1, o2) ->
            o1.getModel().compareToIgnoreCase(o2.getModel());

    private static Comparator<DeviceEntity> compareByManufacturer = (o1, o2) ->
            o1.getManufacturer().compareToIgnoreCase(o2.getManufacturer());

    private static Comparator<DeviceEntity> compareByColour = (o1, o2) ->
            o1.getColour().compareToIgnoreCase(o2.getColour());

    private static Comparator<DeviceEntity> compareByDeviceType = (o1, o2) ->
            o1.getDeviceType().compareToIgnoreCase(o2.getDeviceType());

    private static Comparator<DeviceEntity> compareByPrice = (o1, o2) ->
            o1.getPrice().compareTo(o2.getPrice());

    private static Comparator<DeviceEntity> compareByProductionDate = (o1, o2) ->
            o1.getProductionDate().compareTo(o2.getProductionDate());

    public static List getAllDevicesSortedById() {
        deviceList.sort(compareById);
        return deviceList;
    }

    public static List getAllDevicesSortedByModel() {
        deviceList.sort(compareByModel);
        return deviceList;
    }

    public static List getAllDevicesSortedByManufacturer() {
        deviceList.sort(compareByManufacturer);
        return deviceList;
    }

    public static List getAllDevicesSortedByColour() {
        deviceList.sort(compareByColour);
        return deviceList;
    }

    public static List getAllDevicesSortedByDeviceType() {
        deviceList.sort(compareByDeviceType);
        return deviceList;
    }

    public static List getAllDevicesSortedByPrice() {
        deviceList.sort(compareByPrice);
        return deviceList;
    }

    public static List getAllDevicesSortedByProductionDate() {
        deviceList.sort(compareByProductionDate);
        return deviceList;
    }

    public Long getNextDeviceId() {
        return nextDeviceId;
    }

    public static ArrayList<DeviceEntity> getAllDevicesList() {
        return new ArrayList<>(deviceList);
    }

    public static DeviceService getAllDevicesService() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }

    public static List<DeviceEntity> getDeviceList() {
        return deviceList;
    }
}
