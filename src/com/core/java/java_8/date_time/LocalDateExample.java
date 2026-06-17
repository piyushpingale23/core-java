package com.core.java.java_8.date_time;

import java.time.LocalDate;

public class LocalDateExample {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        System.out.println("Month Day: " + localDate.getDayOfMonth());
        System.out.println("Month: " + localDate.getMonth());
        System.out.println("Year: " + localDate.getYear());

    }
}
