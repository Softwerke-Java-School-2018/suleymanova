package ru.softwerke.Model;

import ru.softwerke.Model.Class.Device;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviseService {
    private static DeviseService deviseService;

    private static List<Device> deviceList;

    private  DeviseService() {
        deviceList = new ArrayList<>();
    }

    public void addNewDevice(long id, String model, String manufacturer, String colour, String deviceType,
                             BigDecimal price, LocalDate productionDate){
        deviceList.add(Device.createDevice(id, model, manufacturer, colour, deviceType, price, productionDate));
    }

    public static List<Device> getDeviceList() {
        return deviceList;
    }

    public static void setDeviceList(List<Device> deviceList) {
        DeviseService.deviceList = deviceList;
    }

    public static DeviseService getDeviceService(){
        if (deviseService == null){
            deviseService = new DeviseService();
        }
        return deviseService;
    }
}
