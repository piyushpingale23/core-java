package com.core.java.cryptography.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesDecryption {

    public static void main(String[] args)
            throws Exception {


        String secretKey =
                "1234567890123456";


        SecretKeySpec key =
                new SecretKeySpec(
                        secretKey.getBytes(),
                        "AES"
                );


        String encrypted =
                "encrypted-data";


        Cipher cipher =
                Cipher.getInstance("AES");


        cipher.init(
                Cipher.DECRYPT_MODE,
                key
        );


        byte[] decrypted =
                cipher.doFinal(
                        Base64.getDecoder()
                                .decode(encrypted)
                );


        System.out.println(
                new String(decrypted)
        );
    }
}