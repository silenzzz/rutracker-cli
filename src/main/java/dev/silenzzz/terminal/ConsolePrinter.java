package dev.silenzzz.terminal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConsolePrinter {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static final String format = "%s%s" + ANSI_RESET;

    public static void printError(String msg) {
        System.out.printf(format, ANSI_RED, msg);
    }

    public static void printSuccess(String msg) {
        System.out.printf(format, ANSI_GREEN, msg);
    }

    public static void printInfo(String msg) {
        System.out.printf(format, ANSI_WHITE, msg);
    }
}
