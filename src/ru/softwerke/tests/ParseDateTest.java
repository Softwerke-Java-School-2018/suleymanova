package ru.softwerke.tests;

import org.junit.jupiter.api.Test;
import ru.softwerke.model.service.ClientService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseDateTest {
    private ClientService testClientService = new ClientService();

    @Test
    public void testParseDate(){
        testClientService.addNewClient(new Long(1), "Vova",
                "Ischenko", LocalDate.parse("1998-05-05"));
        assertEquals(testClientService.getAllClientsList().get(0).getBirthDate(), LocalDate.parse("1998-05-05"));
    }
}
