package main.java.com.caesar_84.smvctest.dao;

import main.java.com.caesar_84.smvctest.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caesar-84 on 2/10/17.
 */

@Repository
public class UserDAOImpl implements UserDAO
{
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void addUser(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("[INFO]: User added. Details: " + user.toString());
    }

    @Override
    public void updateUser(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("[INFO]: User id: " + user.getId() + ", name: " + user.getName() + " updated");
    }

    @Override
    public void deleteUser(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, new Integer(id));
        if (user != null)
        {
            session.delete(user);
            logger.info("[INFO]: User id: " + user.getId() + " name: " + user.getName() + " removed.");
        }
        else logger.info("[INFO]: Such user does not exist.");
    }

    @Override
    public User getUserById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, new Integer(id));

        if (user == null) logger.info("User with id: " + id + " does not exist.");

        return user;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<User> getUsersByName(String name, int page, int resultsPerPage)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User AS U WHERE U.name like '" + name + "%'");
        query.setMaxResults(resultsPerPage);
        query.setFirstResult((page - 1) * resultsPerPage);

        List<User> users = query.list();
        users.forEach(user -> logger.info("[INFO]: " + user.toString() + " imported"));

        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> userList(int page, int resultsPerPage)
    {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User");
        query.setMaxResults(resultsPerPage);
        query.setFirstResult((page - 1) * resultsPerPage);

        List<User> userList = query.list();

        userList.forEach(user -> logger.info("[INFO]: " + user.toString() + " imported"));

        return userList;
    }

    @Override
    public Long getRecordsNumber() {
        Session session = sessionFactory.getCurrentSession();
        String request = "select count(*) from User";
        Query query = session.createQuery(request);
        return (Long) query.uniqueResult();
    }
}