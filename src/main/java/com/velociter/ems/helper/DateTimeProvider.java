package com.velociter.ems.helper;

import java.time.LocalDateTime;

public class DateTimeProvider {
    
    public static LocalDateTime getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime;
    }
}
