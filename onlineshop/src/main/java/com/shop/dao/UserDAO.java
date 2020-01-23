package com.shop.dao;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> FindAllUsers() throws ShopTechnicalException {
            List<User> userList = new ArrayList<>();

            String userLine = FileEdit.read("user.txt","");
            String [] userValues = userLine.split("\\|");
            userList.add(new User(userValues[0], userValues[1], userValues[2], userValues[3]));
            return userList;
    }

    public static void AddUser(String newuserdata) throws ShopTechnicalException {
        FileEdit.write("user.txt", newuserdata);
    }

//    public void updateUser(User User) {
//
//    }
//
//    public void deleteUser(User User) {
//
//    }
}
