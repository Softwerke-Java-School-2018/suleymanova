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


    private static Comparator<DeviceEntity> compareById = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    private static Comparator<DeviceEntity> compareByModel = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getModel().compareToIgnoreCase(o2.getModel());
        }
    };

    private static Comparator<DeviceEntity> compareByManufacturer = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getManufacturer().compareToIgnoreCase(o2.getManufacturer());
        }
    };

    private static Comparator<DeviceEntity> compareByColour = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getColour().compareToIgnoreCase(o2.getColour());
        }
    };

    private static Comparator<DeviceEntity> compareByDeviceType = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getDeviceType().compareToIgnoreCase(o2.getDeviceType());
        }
    };

    private static Comparator<DeviceEntity> compareByPrice = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    };

    private static Comparator<DeviceEntity> compareByProductionDate = new Comparator<DeviceEntity>() {
        @Override
        public int compare(DeviceEntity o1, DeviceEntity o2) {
            return o1.getProductionDate().compareTo(o2.getProductionDate());
        }
    };

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

    public static List<DeviceEntity> getAllDevicesList() {
        return deviceList;
    }

    public static DeviceService getAllDevicesService() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }
}
