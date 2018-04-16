package ru.softwerke;


import ru.softwerke.Model.ClientService;
import ru.softwerke.View.Menu;


public class Main {
    private ClientService clientService = ClientService.getClientService();
    public static void main (String[] args) {
        Menu menu = new Menu();
        menu.clientMenuProcessor();
    }
}