package com.dennis.api;

import com.dennis.api.enums.NavigationOfFunction;
import com.dennis.api.enums.NavigationOfPredicate;
import com.dennis.api.enums.NavigationOfConsumer;
import com.dennis.api.enums.NavigationOfSupplier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

//        NavigationOfConsumer.select(sc);
//
//        boolean booleanFlag=NavigationOfPredicate.select(sc);
//        while(booleanFlag);

        while(!NavigationOfFunction.select(sc).equals("x"));

//        String stringFlag2=NavigationOfSupplier.select(sc);
//        while(!stringFlag2.equals("x"));

        //while (MainNavigationOfPredicate.select(sc));

    }
}