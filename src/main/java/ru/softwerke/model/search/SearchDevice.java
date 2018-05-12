package ru.softwerke.model.search;

import ru.softwerke.model.entity.DeviceEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SearchDevice {
    List search(DeviceEntity device);
}
