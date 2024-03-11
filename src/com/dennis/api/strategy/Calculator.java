package com.dennis.api.strategy;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

enum Operator {

    plus{
        @Override
        public int apply(int a, int b){
            return a+b;
        }
    },minus{
        @Override
        public int apply(int a, int b){
            return a-b;
        }
    },multiply{
        @Override
        public int apply(int a, int b){
            return a*b;
        }
    },divide{
        @Override
        public int apply(int a, int b){
            return a/b;
        }
    };

    public abstract int apply(int a, int b);
}

public class Calculator {
    public static int calculate(int a, int b, Operator operator){
        return operator.apply(a,b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("정수, 정수, 연산자");
        System.out.println(Calculator.calculate(sc.nextInt()
                , sc.nextInt(), Operator.valueOf(sc.next())));

    }
}
