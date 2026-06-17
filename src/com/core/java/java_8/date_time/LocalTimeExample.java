package com.core.java.java_8.date_time;

import java.time.LocalTime;

public class LocalTimeExample {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: " + localTime);

        System.out.println("Hour: " + localTime.getHour());
        System.out.println("Minutes: " + localTime.getMinute());
        System.out.println("Seconds: " + localTime.getSecond());
        System.out.println("Nano-Seconds: " + localTime.getNano());

    }
}
