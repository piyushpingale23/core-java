package com.core.java.java_8.date_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdExample {

    public static void main(String[] args) {

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Current system default Zone: " + zoneId);

        ZoneId la = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(la);
        System.out.println("America/Los_Angeles Date & Time: " + zonedDateTime);

    }
}
