package ru.softwerke.model.search;


import ru.softwerke.model.entity.ClientEntity;

import java.time.LocalDate;
import java.util.List;

public interface SearchClient {
    List search(ClientEntity client);
}
