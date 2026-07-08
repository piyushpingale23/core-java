package com.core.java.docker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DockerVolumeExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        /*
         * This file will be created inside the container.
         *
         * /data/user.txt
         *
         * Later we will mount this directory
         * with a Docker volume.
         */
        String filePath = "/data/user.txt";


        try {

            FileWriter writer = new FileWriter(filePath);

            writer.write("User Name : " + name);

            writer.close();

            System.out.println("Data saved successfully!");

        } catch (IOException e) {

            e.printStackTrace();
        }


        scanner.close();
    }
}