package com.ragheb.dao.impl;

import com.ragheb.dao.api.AbstractDao;
import com.ragheb.dao.api.DaoException;
import com.ragheb.domain.User;
import com.ragheb.mapper.impl.UserMapper;
import com.ragheb.util.MD5Encryptor;
import com.ragheb.util.contanst.UserConstant;

import java.sql.Connection;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    UserDao() {
    }

    UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public int insertItem(User item) throws DaoException {
        System.out.println("UserDao: " + item);
        String encryptPassword = MD5Encryptor.encrypt(item.getUserPassword());
        return executeUpdate(UserConstant.INSERT_USER, item.getUsername(), item.getUserEmail(), encryptPassword,
                item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUserRole().name());
    }

    @Override
    public List<User> getAllItems() throws DaoException {
        return queryForObjects(UserConstant.SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public User getItemById(long id) throws DaoException {
        return queryForObject(UserConstant.SELECT_USER_BY_ID, new UserMapper(), String.valueOf(id));
    }

    @Override
    public int updateItem(User item) throws DaoException {
        return executeUpdate(UserConstant.UPDATE_USER, item.getUsername(), item.getUserEmail(), item.getUserPassword(),
                item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUserRole().name(),
                String.valueOf(item.getUserId()));
    }

    @Override
    public int deleteItem(long id) throws DaoException {
        return executeUpdate(UserConstant.DELETE_USER_BY_ID, String.valueOf(id));
    }

    /// //// Custom Queries ///////

    public User getUserByUserNameAndPassword(String userName, String userPassword) throws DaoException {
        String encryptPassword = MD5Encryptor.encrypt(userPassword).trim();
        return queryForObject(UserConstant.SELECT_USER_BY_USER_NAME_PASSWORD, new UserMapper(), userName, encryptPassword);
    }
}