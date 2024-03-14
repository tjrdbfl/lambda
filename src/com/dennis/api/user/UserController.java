package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private final static UserController userController=new UserController();
    private UserController(){
        this.service = UserServiceImpl.getInstance();
    }
    public static UserController getInstance(){
        return userController;
    }
    private UserServiceImpl service;

    public Messenger addUsers() throws SQLException {
        return service.addUsers();
    }

    public Messenger save(Scanner scanner) throws SQLException {
        return service.save(User.builder()
                .username(scanner.next())
                .address(scanner.next())
                .phone(scanner.next())
                .password(scanner.next())
                .build());
    }
    public Messenger login(Scanner scanner) throws SQLException {
        return service.login(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }
    public Messenger findById(Scanner scanner) throws SQLException {
        return service.findById(scanner.nextInt());
    }
    public Messenger updatePassword(Scanner scanner) {
        return service.updatePassword(User.builder()
                .username(scanner.next())
                .address(scanner.next())
                .phone(scanner.next())
                .password(scanner.next())
                .build());
    }
    public Messenger delete(Scanner scanner) {

        return service.delete(User.builder()
                .username(scanner.next())
                .build());
    }
    public Messenger findAll() throws SQLException {
        return service.findAll();
    }
    public Messenger findUsersByName(Scanner scanner) {
        return service.findUsersByName(scanner.next());
    }
    public Messenger findUsersByJob(Scanner scanner) {
        return service.findUsersByJob(scanner.next());
    }
    public Messenger count() {
        return service.count();
    }

    public Messenger createTable() {
        return service.createTable();
    }

    public Messenger deleteTable() {
        return service.deleteTable();
    }
}
