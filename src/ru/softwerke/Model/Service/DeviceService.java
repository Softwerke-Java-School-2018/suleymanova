package ru.softwerke.Model.Service;

import ru.softwerke.Model.Class.Device;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviceService {
    private static DeviceService deviceService;

    private static List<Device> deviceList;

    private DeviceService() {
        deviceList = new ArrayList<>();
    }

    private long id = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addNewDevice(long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate){
        deviceList.add(Device.createDevice(id, model, manufacturer, colour, deviceType, price, productionDate));
        this.id++;
    }

    public static List<Device> getDeviceList() {
        return deviceList;
    }

    public static void setDeviceList(List<Device> deviceList) {
        DeviceService.deviceList = deviceList;
    }

    public static DeviceService getDeviceService(){
        if (deviceService == null){
            deviceService = new DeviceService();
        }
        return deviceService;
    }
}
