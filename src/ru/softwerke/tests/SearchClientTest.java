package ru.softwerke.tests;

import org.junit.jupiter.api.Test;
import ru.softwerke.controller.ClientController;
import ru.softwerke.model.search.ClientSearcher;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchClientTest {
    private ClientService testClientService = new ClientService();
    private ClientController testClientController = new ClientController();
    private ClientSearcher testClientSearcher = new ClientSearcher();
    @Test
    public void testSearchClient() {
        testClientService.addNewClient(new Long(1), "Ilya",
                "Fedorov", LocalDate.parse("1996-06-23"));
        testClientService.addNewClient(new Long(2), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        testClientController.searchById(new Long(2));
        assertEquals(testClientSearcher.getWantedClientsList().get(0).getId(), new Long(2));



    }
}
