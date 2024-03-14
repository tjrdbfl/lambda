package com.dennis.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    monday("1",i->"Monday"),
    tuesday("2",i->"Tuesday"),
    wednesday("3",i->"Wednesday"),
    thursday("4",i->"Thursday"),
    friday("5",i->"Friday"),
    saturday("6",i->"Saturday"),
    sunday("7",i->"Sunday"),
    wrong("?",i->"Wrong"),
    ;
    private final String day;
    private final Function<Scanner,String> function;

    WeekendStrategy(String day, Function<Scanner, String> function) {
        this.day = day;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("1~7입력: ");
        String s=sc.next();
        return Stream.of(values())
                .filter(i->i.day.equals(s))
                .findAny().orElseGet(()->WeekendStrategy.valueOf("wrong"))
                .function.apply(sc);
    }
}
