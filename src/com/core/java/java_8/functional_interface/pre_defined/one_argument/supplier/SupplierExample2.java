package com.core.java.java_8.functional_interface.pre_defined.one_argument.supplier;

import java.util.function.Supplier;

public class SupplierExample2 {

    public static void main(String[] args) {

        Supplier<StringBuilder> supplier = () -> {

            StringBuilder otp = new StringBuilder();
            for (int i = 1; i <= 6; i++) {
                otp.append((int) (Math.random() * 10));
            }

            return otp;
        };

        System.out.println("OTP: " + supplier.get());


    }
}
