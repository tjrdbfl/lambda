package com.dennis.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationOfConsumer {
    ;
    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public static boolean select(Scanner sc) {
        return false;
    }
}
