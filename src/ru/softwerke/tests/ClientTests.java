package ru.softwerke.tests;

import org.junit.After;
import org.junit.jupiter.api.Test;
import ru.softwerke.controller.ClientController;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTests {
    private ClientService testClientService = new ClientService();
    private ClientController testClientController = new ClientController();

/*
    @Before
    public void init() {
        testClientService.addNewClient(new Long(50), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
    }
*/

    @After
    public void tearDown() {
        testClientService = null;
    }

    @Test
    public void testAddNewClient() {
        testClientService.addNewClient(new Long(1), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        assertEquals(testClientService.getAllClientsList().get(0).getId(), new Long(1));
        assertEquals(testClientService.getAllClientsList().get(0).getFirstName(), "Vova");
        assertEquals(testClientService.getAllClientsList().get(0).getLastName(), "Ischenko");
        assertEquals(testClientService.getAllClientsList().get(0).getBirthDate(), LocalDate.parse("1998-05-05"));
    }

    @Test
    public void testChangeClientInformation() {
        testClientService.addNewClient(new Long(1), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        testClientService.getAllClientsList().get(0).setLastName("Chernyh");
        assertEquals(testClientService.getAllClientsList().get(0).getLastName(), "Chernyh");
    }

    @Test
    public void testDeleteClient() {
        testClientService.addNewClient(new Long(1), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        ClientController.deleteClient(new Long(1));
        assertEquals(0, testClientService.getAllClientsList().size());

    }
}