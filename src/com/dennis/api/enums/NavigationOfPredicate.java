package com.dennis.api.enums;

import java.util.Scanner;
import java.util.function.Predicate;

public enum NavigationOfPredicate {
    ;
    private final String name;
    private final Predicate<Scanner> predicate;

    NavigationOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        return false;
    }
}
