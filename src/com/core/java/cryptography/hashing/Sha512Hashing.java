package com.core.java.cryptography.hashing;

import java.security.MessageDigest;

public class Sha512Hashing {

    public static void main(String[] args) throws Exception {

        // MessageDigest is a Java class used to generate one-way hash values from input data such as text, files, or byte arrays.
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] hash = md.digest("Hello Java".getBytes());

        for(byte b:hash){
            System.out.printf("%02x", b);
        }
    }
}