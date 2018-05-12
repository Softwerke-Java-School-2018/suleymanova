package ru.softwerke.model.service;

import ru.softwerke.model.entity.ClientEntity;
import ru.softwerke.model.entity.DeviceEntity;
import ru.softwerke.model.entity.SaleEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SaleService {
    private static ClientService clientService = ClientService.getAllClientsService();
    private static DeviceService deviceService = DeviceService.getAllDevicesService();

    private static final List<ClientEntity> clientBuyer;
    private static ArrayList<DeviceEntity> purchasedDevices;
    private static List<SaleEntity> historyOfSales;

    private static int idOfPurchasedDevice = 0;
    private static BigDecimal amountOfAllSale = BigDecimal.ZERO;


    static {
        clientBuyer = new ArrayList<>();
        purchasedDevices = new ArrayList<>();
        historyOfSales = new ArrayList<>();
    }

    public SaleService() {
    }

    @Override
    public String toString() {
        return clientBuyer.get(0).getFirstName() + " " + clientBuyer.get(0).getLastName();
    }



    public static List<ClientEntity> clientBuyer(Long buyerId) {
        for (ClientEntity clientEntity : clientService.getAllClientsList()) {
            if (clientEntity.getId().equals(buyerId)) {
                clientBuyer.add(clientEntity);
                break;
            }
        }
        //return clientBuyer.get(0).getFirstName() + " " + clientBuyer.get(0).getLastName();
        return clientBuyer;
    }

    public static ClientEntity getClientBuyer() {
        return clientBuyer.get(0);

    }

    public static void setPurchasedDevice(Long idOfDevice) {
        List<DeviceEntity> deviceList = DeviceService.getDeviceList();
        int devIndex = -1;
        for (DeviceEntity deviceEntity : DeviceService.getAllDevicesList()) {
            devIndex++;
            if (deviceEntity.getId().longValue() == idOfDevice.longValue()) {
                purchasedDevices.add(deviceEntity);
                deviceList.remove(devIndex);
                break;
            }
        }

    }

    public static String getInformationAboutPurchasedDevices() {

        return purchasedDevices.get(idOfPurchasedDevice).getDeviceType() + " " +
                purchasedDevices.get(idOfPurchasedDevice).getManufacturer() + " " +
                purchasedDevices.get(idOfPurchasedDevice).getModel() + " " +
                purchasedDevices.get(idOfPurchasedDevice).getColour() + " " +
                purchasedDevices.get(idOfPurchasedDevice).getPrice();
    }

    public static void amountOfSale() {
        amountOfAllSale = amountOfAllSale.add(purchasedDevices.get(idOfPurchasedDevice).getPrice());
        idOfPurchasedDevice++;
    }

    public static BigDecimal getAmountOfAllSale() {
        return amountOfAllSale;
    }

    public static void addInHistoryOfSales(String clientName, List<DeviceEntity> listOfPurchasedDevices,
                                           LocalDate dateOfSale, BigDecimal amountOfSale) {
        historyOfSales.add(SaleEntity.addingInHistoryOfSales(clientName, listOfPurchasedDevices, dateOfSale, amountOfSale));
    }

    public static void clearPurchase() {
        amountOfAllSale = BigDecimal.ZERO;
        purchasedDevices.clear();
        idOfPurchasedDevice = 0;
        clientBuyer.clear();
    }


    public static List<DeviceEntity> getPurchasedDevices() {

        return new ArrayList<>(purchasedDevices);
    }

    public static List<SaleEntity> getHistoryOfSales() {
        return historyOfSales;
    }


}
