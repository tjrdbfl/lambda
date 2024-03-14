package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private UserRepository userRepository;

    private UserServiceImpl(){
        userRepository=UserRepository.getInstance();
    }
    public static UserServiceImpl getInstance(){return instance;}

    @Override
    public Messenger addUsers() throws SQLException {
        return userRepository.addUsers();
    }

    @Override
    public Messenger login(User user) throws SQLException {
        return userRepository.login(user);
    }

    @Override
    public Messenger updatePassword(User user) {
        return null;
    }

    @Override
    public Messenger findUsersByName(String name) {
        return userRepository.findUsersByName(name);
    }

    @Override
    public Messenger findUsersByJob(String job) {
        return userRepository.findUsersByJob(job);
    }

    @Override
    public Messenger getUserMap() {
        return null;
    }

    @Override
    public Messenger save(User user) throws SQLException {
        return userRepository.save(user);
    }

    @Override
    public Messenger findAll() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public Messenger findById(int id) throws SQLException {
        return userRepository.findById(id);
    }

    @Override
    public Messenger delete(User build) {
        return null;
    }

    @Override
    public Messenger count() {
        return userRepository.count();
    }

    @Override
    public Messenger createTable() {
        return userRepository.createTable();
    }

    @Override
    public Messenger deleteTable() {
        return userRepository.deleteTable();
    }

}