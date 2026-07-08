package com.core.java.cryptography.encryption;

import javax.crypto.Cipher;
import java.security.*;

public class RsaDecryption {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        KeyPair pair = generator.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");

        String message = "Hello RSA";

        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        byte[] encrypted = cipher.doFinal(message.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println(new String(decrypted));
    }
}
