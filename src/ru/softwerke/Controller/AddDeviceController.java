package ru.softwerke.Controller;

import ru.softwerke.Model.DeviseService;

import java.time.LocalDate;
import java.util.Scanner;

public class AddDeviceController {
    DeviseService deviseService = DeviseService.getDeviceService();
    long id = 0;

    public DeviseService addNewDevice(){
        Scanner in = new Scanner(System.in);
        deviseService.addNewDevice(id, in.next(), in.next(), in.next(), in.next(), in.nextBigDecimal(),
                LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()));
        id++;
        return (deviseService);
    }
}
