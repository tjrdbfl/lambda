package com.dennis.api.menus;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.menu;

public class MenuServiceImpl implements MenuService{
    private final static MenuServiceImpl instance;

    static {
        try {
            instance = new MenuServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MenuRepository menuRepository;

    private MenuServiceImpl() throws SQLException {
        menuRepository=MenuRepository.getInstance();
    }
    public static MenuServiceImpl getInstance(){
        return instance;
    }

    @Override
    public Messenger makeTable() {
        return menuRepository.makeTable();
    }
    @Override
    public void insertMenus() {
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
                {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"}};
        for(int i=0;i<categories.length;i++)
            for(int j=0;j< menus[i].length;j++)
                menuRepository.insertMenus(Menu.builder().category(categories[i])
                                .item(menus[i][j]).build());

    }
    @Override
    public Messenger showTable() throws SQLException {
        return menuRepository.showTable();
    }
    @Override
    public List<?> getMenusByCategory(String category) {
        return menuRepository.getMenusByCategory(category);
    }

    @Override
    public void removeTable() {
        menuRepository.removeTable();
    }

    @Override
    public Messenger returnMessenger() throws SQLException {
        return menuRepository.returnMessenger();
    }


}
