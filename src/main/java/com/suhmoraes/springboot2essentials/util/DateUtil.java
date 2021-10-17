package com.suhmoraes.springboot2essentials.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabase(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss").format(localDateTime);
    }
}
