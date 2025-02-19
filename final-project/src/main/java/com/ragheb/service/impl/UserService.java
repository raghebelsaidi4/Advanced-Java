package com.ragheb.service.impl;

import com.ragheb.dao.api.DaoException;
import com.ragheb.dao.impl.UserDao;
import com.ragheb.domain.User;
import com.ragheb.service.api.GenericService;
import com.ragheb.service.api.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserService implements GenericService<User> {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private final UserDao userDao;

    /**
     * Constructor for UserService.
     *
     * @param userDao the DAO for accessing User data
     */
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int insertItem(User item) throws ServiceException {
        try {
            return userDao.insertItem(item);
        } catch (DaoException e) {
            LOGGER.error("Unable to insert user in UserService", e);
            throw new ServiceException("Unable to insert user in UserService", e);
        }
    }

    @Override
    public List<User> getAllItems() throws ServiceException {
        try {
            return userDao.getAllItems();
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve all users in UserService", e);
            throw new ServiceException("Unable to retrieve all users in UserService", e);
        }
    }

    @Override
    public User getItemById(long id) throws ServiceException {
        try {
            return userDao.getItemById(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve user by ID in UserService", e);
            throw new ServiceException("Unable to retrieve user by ID in UserService", e);
        }
    }

    @Override
    public int updateItem(User item) throws ServiceException {
        try {
            return userDao.updateItem(item);
        } catch (DaoException e) {
            LOGGER.error("Unable to update user in UserService", e);
            throw new ServiceException("Unable to update user in UserService", e);
        }
    }

    @Override
    public int deleteItem(long id) throws ServiceException {
        try {
            return userDao.deleteItem(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to delete user in UserService", e);
            throw new ServiceException("Unable to delete user in UserService", e);
        }
    }

    /////// Custom Service ///////

    /**
     * Retrieves a user based on username and password.
     *
     * @param userName     the username of the user
     * @param userPassword the password of the user
     * @return the user if found
     * @throws ServiceException if a database error occurs
     */
    public User getUserByUserNameAndPassword(String userName, String userPassword) throws ServiceException {
        try {
            return userDao.getUserByUserNameAndPassword(userName, userPassword);
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve user by username and password in UserService", e);
            throw new ServiceException("Unable to retrieve user by username and password in UserService", e);
        }
    }
}
