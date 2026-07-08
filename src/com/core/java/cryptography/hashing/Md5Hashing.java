package com.core.java.cryptography.hashing;

import java.security.MessageDigest;

public class Md5Hashing {

    public static void main(String[] args) throws Exception {

        // MessageDigest is a Java class used to generate one-way hash values from input data such as text, files, or byte arrays.
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] hash = md.digest("password".getBytes());

        System.out.println(bytesToHex(hash));
    }


    static String bytesToHex(byte[] bytes){

        StringBuilder sb = new StringBuilder();

        for(byte b: bytes){
            sb.append(String.format("%02x",b));
        }

        return sb.toString();
    }
}
