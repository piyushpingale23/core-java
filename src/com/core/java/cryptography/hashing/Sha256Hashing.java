package com.core.java.cryptography.hashing;

import java.security.MessageDigest;

public class Sha256Hashing {

    public static void main(String[] args) throws Exception {

        // MessageDigest is a Java class used to generate one-way hash values from input data such as text, files, or byte arrays.
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hash = md.digest("Hello Java".getBytes());

        StringBuilder sb = new StringBuilder();
        for(byte b:hash){
            sb.append(String.format("%02x",b));
        }

        System.out.println(sb);
    }
}
