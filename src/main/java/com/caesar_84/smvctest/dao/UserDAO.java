package main.java.com.caesar_84.smvctest.dao;

import main.java.com.caesar_84.smvctest.model.User;

import java.util.List;

/**
 * Created by caesar-84 on 2/10/17.
 */
public interface UserDAO {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    Long getRecordsNumber();

    User getUserById(int id);

    List<User> getUsersByName(String name, int page, int resultsPerPage);

    List<User> userList(int page, int resultsPerPage);
}
