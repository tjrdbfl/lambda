package com.dennis.api.strategy;

import java.util.Scanner;

public class Weekend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day=WeekendStrategy.execute(sc);
        System.out.printf("전략의 결과 : "+day);
    }

}
