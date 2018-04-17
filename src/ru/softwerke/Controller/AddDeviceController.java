package ru.softwerke.Controller;

import ru.softwerke.Model.Service.DeviceService;

import java.time.LocalDate;
import java.util.Scanner;

public class AddDeviceController {
    DeviceService deviceService = DeviceService.getDeviceService();



    public DeviceService addNewDevice(){
        Scanner in = new Scanner(System.in);
        deviceService.addNewDevice(deviceService.getId(), in.next(), in.next(), in.next(), in.next(),
                in.nextBigDecimal(), LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));
        return (deviceService);
    }


}
