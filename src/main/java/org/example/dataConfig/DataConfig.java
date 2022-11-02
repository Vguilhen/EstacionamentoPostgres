package org.example.dataConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataConfig {

    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public String formatDateTime = localDateTime.format(formatter);

    public String formatDateTime(LocalDateTime localDateTime) {
        return formatDateTime;
    }

}
