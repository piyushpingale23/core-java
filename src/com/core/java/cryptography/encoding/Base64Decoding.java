package com.core.java.cryptography.encoding;

import java.util.Base64;

public class Base64Decoding {

    public static void main(String[] args) {

        String encoded = "SGVsbG8gSmF2YSBDcnlwdG9ncmFwaHk=";

        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        String decoded = new String(decodedBytes);

        System.out.println("Encoded : " + encoded);
        System.out.println("Decoded : " + decoded);
    }
}
