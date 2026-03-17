package com.core.java.exception.custom.runtime;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(String s) {
        super(s); // ->  // Passing custom message to parent RuntimeException class
    }
}
