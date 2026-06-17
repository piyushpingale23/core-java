package com.core.java.java_8.date_time;

import java.time.LocalDate;
import java.time.Period;

// Write a Java program to calculate a person's age from their birthdate and display the age
// in years, months, and days using the Java 8 Date-Time API.
public class LocalDateExample1 {

    public static void main(String[] args) {

        LocalDate birthDate = LocalDate.of(1998, 9, 23);
        LocalDate today = LocalDate.now();

        Period period = Period.between(birthDate, today);
        System.out.println("Current Age: " + period);

        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
    }
}
