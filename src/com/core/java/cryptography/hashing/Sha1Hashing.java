package com.core.java.cryptography.hashing;

import java.security.MessageDigest;

public class Sha1Hashing {

    public static void main(String[] args) throws Exception {

        // MessageDigest is a Java class used to generate one-way hash values from input data such as text, files, or byte arrays.
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hash = md.digest("Hello".getBytes());

        for(byte b:hash){
            System.out.printf("%02x",b);
        }
    }
}
