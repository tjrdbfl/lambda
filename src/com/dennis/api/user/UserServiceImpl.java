package com.dennis.api.user;

import com.dennis.api.common.AbstractService;
import com.dennis.api.common.UtilServiceImpl;
import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private UserRepository userRepository;

    private UserServiceImpl(){
        userRepository=UserRepository.getInstance();
    }
    public static UserServiceImpl getInstance(){return instance;}

    @Override
    public Messenger addUsers(String a) {
        return userRepository.create();
    }

    @Override
    public Messenger login(User user) {
        return null;
    }

    @Override
    public Messenger updatePassword(User user) {
        return null;
    }

    @Override
    public Messenger findUsersByName(String name) {
        return null;
    }

    @Override
    public Messenger findUsersByNameFromMap(String name) {
        return null;
    }

    @Override
    public Messenger findUsersByJob(String job) {
        return null;
    }

    @Override
    public Messenger findUsersByJobFromMap(String job) {
        return null;
    }

    @Override
    public Messenger getUserMap() {
        return null;
    }
}