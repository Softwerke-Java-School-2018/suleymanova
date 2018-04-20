package ru.softwerke.model.search;

import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.service.DeviceService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DevicesSearches {
    private static DeviceService deviceService = DeviceService.getAllDevicesService();

    private static List<DeviceEntity> wantedDeviceList;

    public DevicesSearches(){
        wantedDeviceList = new ArrayList<>();
    }

    public static List<DeviceEntity> searchById(Long wantedId){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: deviceService.getAllDevicesList()){
            if (deviceEntity.getId().equals(wantedId)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchByModel(String wantedModel){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getModel().equalsIgnoreCase(wantedModel)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchByManufacturer(String wantedManufacturer){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getManufacturer().equalsIgnoreCase(wantedManufacturer)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchByColour(String wantedColour){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getColour().equalsIgnoreCase(wantedColour)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchDeviceType(String wantedDeviceType){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getDeviceType().equalsIgnoreCase(wantedDeviceType)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchByPrice(BigDecimal wantedPrice){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getPrice().equals(wantedPrice)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }

    public static List<DeviceEntity> searchByProductionDate(LocalDate wantedProductionDate){
        wantedDeviceList.clear();
        for (DeviceEntity deviceEntity: DeviceService.getAllDevicesList()){
            if (deviceEntity.getProductionDate().equals(wantedProductionDate)){
                wantedDeviceList.add(deviceEntity);
            }
        }
        return wantedDeviceList;
    }
}
