package com.core.java.java_8.functional_interface.pre_defined.one_argument.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample1 {

    public static void main(String[] args) {

        Supplier<Date> supplier = Date::new;
        System.out.println("Date: " + supplier.get());

    }
}
