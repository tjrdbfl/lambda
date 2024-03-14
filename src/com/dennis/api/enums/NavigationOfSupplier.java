package com.dennis.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSupplier {

    Exit("exit",()-> "x"),
    User("user",()-> "u"),
    Account("account",()-> "ac"),
    Crawler("crawler",()-> "c"),
    Article("article",()->"a")
    ;

    private final String name;
    private final Supplier<String> supplier;

    NavigationOfSupplier(String name, Supplier<String> supplier) {
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

        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny()
                .orElseThrow()
                .supplier.get();
    }
}
