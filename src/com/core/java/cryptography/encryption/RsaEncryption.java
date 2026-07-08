package com.core.java.cryptography.encryption;

import javax.crypto.Cipher;
import java.security.*;

import java.util.Base64;

public class RsaEncryption {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        KeyPair pair = generator.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        String message = "RSA Encryption Example";

        byte[] encrypted = cipher.doFinal(message.getBytes());

        System.out.println(Base64.getEncoder().encodeToString(encrypted)
        );
    }
}
