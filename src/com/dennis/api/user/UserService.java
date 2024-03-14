package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    Messenger addUsers() throws SQLException;
    Messenger login(User user) throws SQLException;
    Messenger updatePassword(User user);
    Messenger findUsersByName(String name);
    Messenger findUsersByJob(String job);
    Messenger getUserMap();

    Messenger save(User build) throws SQLException;

    Messenger findAll() throws SQLException;

    Messenger findById(int id) throws SQLException;

    Messenger delete(User build);

    Messenger count();

    Messenger createTable();

    Messenger deleteTable();
}
