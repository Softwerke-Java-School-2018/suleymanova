package ru.softwerke.Model.Service;

import ru.softwerke.Model.Class.Device;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeviceService {
    private static DeviceService deviceService;

    private static List<Device> deviceList;

    private DeviceService() {
        deviceList = new ArrayList<>();
    }

    private Long id = (long)0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addNewDevice(long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate) {
        deviceList.add(Device.createDevice(id, model, manufacturer, colour, deviceType, price, productionDate));
        this.id++;
    }

    public static List<Device> getDeviceList() {
        return deviceList;
    }

    public static void setDeviceList(List<Device> deviceList) {
        DeviceService.deviceList = deviceList;
    }

    public static DeviceService getDeviceService() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }

    private static Comparator<Device> compareById = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    private static Comparator<Device> compareByModel = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getModel().compareToIgnoreCase(o2.getModel());
        }
    };

    private static Comparator<Device> compareByManufacturer = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getManufacturer().compareToIgnoreCase(o2.getManufacturer());
        }
    };

    private static Comparator<Device> compareByColour = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getColour().compareToIgnoreCase(o2.getColour());
        }
    };

    private static Comparator<Device> compareByDeviceType = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getDeviceType().compareToIgnoreCase(o2.getDeviceType());
        }
    };

    private static Comparator<Device> compareByPrice = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    };

    private static Comparator<Device> compareByProductionDate = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getProductionDate().compareTo(o2.getProductionDate());
        }
    };

    public static List comparingById() {
        deviceList.sort(compareById);
        return deviceList;
    }

    public static List comparingByModel() {
        deviceList.sort(compareByModel);
        return deviceList;
    }

    public static List comparingByManufacturer() {
        deviceList.sort(compareByManufacturer);
        return deviceList;
    }

    public static List comparingByColour() {
        deviceList.sort(compareByColour);
        return deviceList;
    }

    public static List comparingByDeviceType() {
        deviceList.sort(compareByDeviceType);
        return deviceList;
    }

    public static List comparingByPrice() {
        deviceList.sort(compareByPrice);
        return deviceList;
    }

    public static List comparingByProductionDate() {
        deviceList.sort(compareByProductionDate);
        return deviceList;
    }
}
