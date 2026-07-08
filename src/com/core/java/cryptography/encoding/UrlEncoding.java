package com.core.java.cryptography.encoding;

import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class UrlEncoding {

    public static void main(String[] args) throws Exception {

        String url = "Hello Java & Spring Boot";

        String encoded = URLEncoder.encode(
                url,
                StandardCharsets.UTF_8
        );

        System.out.println("Encoded : " + encoded);


        String decoded = URLDecoder.decode(
                encoded,
                StandardCharsets.UTF_8
        );

        System.out.println("Decoded : " + decoded);
    }
}