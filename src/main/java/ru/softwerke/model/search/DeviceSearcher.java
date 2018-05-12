package ru.softwerke.model.search;

import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.service.DeviceService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class DeviceSearcher implements SearchDevice {
    private BiPredicate<DeviceEntity, DeviceEntity> isDeviceMatchesPredicate;

    private static DeviceService deviceService = DeviceService.getAllDevicesService();

    private static List<DeviceEntity> wantedDeviceList;

    public DeviceSearcher() {
        wantedDeviceList = new ArrayList<>();
    }

    public DeviceSearcher(String fieldName) {
        switch (fieldName) {
            case "id":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getId().equals(c2.getId()));
                };
                break;
            case "model":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getModel().equalsIgnoreCase(c2.getModel()));
                };
                break;
            case "manufacturer":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getManufacturer().equalsIgnoreCase(c2.getManufacturer()));
                };
                break;
            case "colour":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getColour().equalsIgnoreCase(c2.getColour()));
                };
                break;
            case "type":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getDeviceType().equalsIgnoreCase(c2.getDeviceType()));
                };
                break;
            case "price":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getPrice().equals(c2.getPrice()));
                };
                break;
            case "productionDate":
                isDeviceMatchesPredicate = (c1, c2) -> {
                    return (c1.getProductionDate().equals(c2.getProductionDate()));
                };
                break;

        }
        wantedDeviceList = new ArrayList<>();
    }


    @Override
    public List<DeviceEntity> search(DeviceEntity device) {
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity : DeviceService.getAllDevicesList()) {
            if (isDeviceMatchesPredicate.test(device, deviceEntity)) {
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }
}