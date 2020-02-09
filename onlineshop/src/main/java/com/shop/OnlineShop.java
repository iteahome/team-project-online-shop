package com.shop;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.model.User;
import com.shop.ui.MainUI;

import java.util.List;

/** OnlineShop class - the program entry point. */

public class OnlineShop {

    public static void main (String[] args) throws ShopException {

//      TEST
        UserDAO myDAO = new UserDAO();
        List<User> myUsers = myDAO.findAllUsers();

        for(int i = 0; i < myUsers.size(); i++) {
            System.out.println(myUsers.get(i).getUserName() + "|" + myUsers.get(i).getPassword() + "|" + myUsers.get(i).getEmail() + "|" + myUsers.get(i).getPhoneNo());
        }
//      END OF TEST

        MainUI mainUI = new MainUI();
        mainUI.start();
    }
}
