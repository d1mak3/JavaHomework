package com.homework.handlers;

import java.io.IOException;

public class ConsoleHandler {
    public static void writeLine(Object output) {
        System.out.println(output);
    }

    public static String readLine() {
        StringBuilder finalString = new StringBuilder();
        int byteFromInputStream;

        try {
            while ((byteFromInputStream = System.in.read()) != 10) {
                finalString.append((char) byteFromInputStream);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return finalString.toString();
    }
}
