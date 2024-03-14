package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.util.List;
import java.util.Map;

public interface UserService {
    Messenger addUsers();
    Messenger login(User user);
    Messenger updatePassword(User user);
    Messenger findUsersByName(String name);
    Messenger findUsersByNameFromMap(String name);
    Messenger findUsersByJob(String job);
    Messenger findUsersByJobFromMap(String job);
    Messenger getUserMap();
}
