package ru.softwerke.model.utils;

import java.io.InputStream;
import java.util.Scanner;

public final class UtilsHelper {
    public static final InputStream SCANNER_SOURCE = System.in;

    private static Scanner scanner;

    static {
        scanner = new Scanner(SCANNER_SOURCE);
    }

    private UtilsHelper() {
    }

    public static Scanner getScanner() {
        return scanner;
    }
}

