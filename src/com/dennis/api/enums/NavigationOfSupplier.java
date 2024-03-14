package com.dennis.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigationOfSupplier {

    Exit("exit",()-> {return true;}),
    User("user",()-> {return true;}),
    Account("account",()-> {return true;}),
    Crawler("crawler",()-> {return true;}),
    Article("article",()-> {return true;})
    ;

    private final String name;
    private final Supplier<Boolean> supplier;

    NavigationOfSupplier(String name, Supplier<Boolean> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public static String select(Scanner sc) {
        System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "a-Article " +
                "===");

        String str = sc.next();

        return str;
    }
}
