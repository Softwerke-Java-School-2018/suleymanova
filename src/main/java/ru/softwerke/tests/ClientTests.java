package ru.softwerke.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.softwerke.controller.ClientController;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class ClientTests {
    private static ClientService testClientService;


    private ClientController testClientController = new ClientController();

    @BeforeClass
    public static void init() {
        testClientService = new ClientService();
        testClientService.addNewClient(new Long(50), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
    }


    @Test
    public void testAddNewClient() {
        assertEquals(testClientService.getAllClientsList().get(0).getId(), new Long(1));
        assertEquals(testClientService.getAllClientsList().get(0).getFirstName(), "Vova");
        assertEquals(testClientService.getAllClientsList().get(0).getLastName(), "Ischenko");
        assertEquals(testClientService.getAllClientsList().get(0).getBirthDate(), LocalDate.parse("1998-05-05"));
    }

    @Test
    public void testChangeClientInformation() {

        testClientService.getAllClientsList().get(0).setLastName("Chernyh");
        assertEquals(testClientService.getAllClientsList().get(0).getLastName(), "Chernyh");
    }

    @Test
    public void testDeleteClient() {

        ClientController.deleteClient(new Long(1));
        assertEquals(0, testClientService.getAllClientsList().size());

    }

    @AfterClass
    public static void tearDown() {
        testClientService = null;
    }

}