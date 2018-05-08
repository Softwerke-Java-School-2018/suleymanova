package ru.softwerke.tests;

import org.junit.jupiter.api.Test;
import ru.softwerke.controller.ClientController;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortClientTest {
    private ClientService testClientService = new ClientService();
    private ClientController testClientController = new ClientController();

    @Test
    public void testSortClient() {
        testClientService.addNewClient(new Long(1), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        testClientService.addNewClient(new Long(2), "Ilya",
                "Fedorov", LocalDate.parse("1996-06-23"));

        testClientController.sortByLastName();

        assertEquals(testClientService.getAllClientsList().get(0).getLastName(), "Fedorov");
        assertEquals(testClientService.getAllClientsList().get(1).getLastName(), "Ischenko");
    }
}
