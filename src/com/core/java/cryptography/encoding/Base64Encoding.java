package com.core.java.cryptography.encoding;

import java.util.Base64;

public class Base64Encoding {

    public static void main(String[] args) {

        String data = "Hello Java Cryptography";

        String encoded = Base64.getEncoder().encodeToString(data.getBytes());

        System.out.println("Original : " + data);
        System.out.println("Encoded  : " + encoded);
    }
}
