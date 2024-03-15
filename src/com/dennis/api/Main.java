package com.dennis.api;

import com.dennis.api.enums.Messenger;
import com.dennis.api.enums.Navigation;
import com.dennis.api.menus.Menu;
import com.dennis.api.menus.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Messenger msg=MenuController.getInstance().returnMessenger();
        Menu oneMenu=MenuController.getInstance().returnOneMenu();
        List<?> allMenu=MenuController.getInstance().returnAllMenu();

//        MenuController.getInstance().removeTable();
//        MenuController.getInstance().makeTable();
//        MenuController.getInstance().insertMenus();

        Scanner sc = new Scanner(System.in);

        while (Navigation.select(sc));

    }
}