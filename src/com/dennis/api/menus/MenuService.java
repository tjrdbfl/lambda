package com.dennis.api.menus;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    public Messenger makeTable();

    public void insertMenus();
    public Messenger showTable() throws SQLException;
    public List<?> getMenusByCategory(String category);

    void removeTable();

    Messenger returnMessenger() throws SQLException;
}
