package com.dennis.api.user;

import com.dennis.api.enums.UserRouter;


import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) {
        while (UserRouter.select(sc));
    }
}
