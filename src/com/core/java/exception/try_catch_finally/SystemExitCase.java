package com.core.java.exception.try_catch_finally;

public class SystemExitCase {

    public static void main(String[] args) {

        try {
            System.out.println("Try");
            System.exit(0);
        } finally {
            System.out.println("Won't execute");
        }
    }
}