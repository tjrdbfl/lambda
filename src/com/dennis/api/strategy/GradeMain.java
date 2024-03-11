package com.dennis.api.strategy;

import java.util.Arrays;
import java.util.Scanner;

enum Grade{
    a(9),
    b(8),
    c(7),
    d(6),
    f(5)
     ;

    private final int score;

    Grade(int score) {
        this.score = score;
    }

    static String getGrade(int score){
        return Arrays.stream(values())
                .filter(i->i.score <= (score/10) && score>0)
                .findFirst()
                .orElse(Grade.valueOf("f"))
                .toString();
    }
}
public class GradeMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(Grade.getGrade(sc.nextInt()));
    }
}
