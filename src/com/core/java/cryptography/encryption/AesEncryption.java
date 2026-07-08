package com.core.java.cryptography.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AesEncryption {

    public static void main(String[] args) throws Exception {

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128);

        SecretKey key = generator.generateKey();

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        String message = "Sensitive Information";

        byte[] encrypted = cipher.doFinal(message.getBytes());

        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Encrypted : " + encryptedText);
    }
}
