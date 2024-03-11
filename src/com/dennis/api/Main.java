package com.dennis.api;

import com.dennis.api.enums.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "a-Article " +
                "===");
        } while (Navigation.mainmenu(sc.next(),sc));

    }
}