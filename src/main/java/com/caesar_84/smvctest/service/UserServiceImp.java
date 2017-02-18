package main.java.com.caesar_84.smvctest.service;

import main.java.com.caesar_84.smvctest.dao.UserDAO;
import main.java.com.caesar_84.smvctest.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caesar-84 on 2/10/17.
 */
@Service
public class UserServiceImp implements UserService
{
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user)
    {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id)
    {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id)
    {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getUsersByName(String name, int page, int resultsPerPage)
    {
        return userDAO.getUsersByName(name, page, resultsPerPage);
    }

    @Override
    @Transactional
    public List<User> userList(int page, int resultsPerPage)
    {
        return userDAO.userList(page, resultsPerPage);
    }

    @Override
    @Transactional
    public Long getRecordsNumber() {
        return userDAO.getRecordsNumber();
    }
}
