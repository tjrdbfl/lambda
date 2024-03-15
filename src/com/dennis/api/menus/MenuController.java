package com.dennis.api.menus;

import com.dennis.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuController {
    @Getter
    private final static MenuController instance=new MenuController();

    private MenuServiceImpl menuService;
    private MenuController() {
        menuService=MenuServiceImpl.getInstance();
    }
    public static MenuController getInstance(){return instance;}

    public Messenger makeTable() {
        return menuService.makeTable();
    }

    public void insertMenus() {
        menuService.insertMenus();
    }
    public Messenger showTable() throws SQLException {
        return menuService.showTable();
    }
    public List<?> getMenusByCategory(String category) {
        return menuService.getMenusByCategory(category);
    }

    public void removeTable() {
        menuService.removeTable();
    }

    public Messenger returnMessenger() {
        return menuService.returnMessenger();
    }

    public Menu returnOneMenu() {
        return Menu.builder().build();
    }

    public List<?> returnAllMenu() {
        return new ArrayList<>();
    }
}
