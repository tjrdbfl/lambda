package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    Messenger addUsers() throws SQLException;
    Messenger login(User user) throws SQLException;
    Messenger updatePassword(User user);
    Messenger findUsersByName(String name) throws SQLException;
    Messenger findUsersByJob(String job) throws SQLException;
    Messenger save(User build) throws SQLException;

    Messenger findAll() throws SQLException;

    Messenger findById(int id) throws SQLException;

    Messenger count() throws SQLException;

    Messenger createTable() throws SQLException;

    Messenger deleteTable() throws SQLException;
}
