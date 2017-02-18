package main.java.com.caesar_84.smvctest.service;

import main.java.com.caesar_84.smvctest.model.User;

import java.util.List;

/**
 * Created by caesar-84 on 2/10/17.
 */
public interface UserService
{
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    List<User> getUsersByName(String name, int page, int resultsPerPage);

    List<User> userList(int page, int resultsPerPage);

    Long getRecordsNumber();
}
