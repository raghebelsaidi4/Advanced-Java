package com.ragheb.mapper.impl;

import com.ragheb.domain.User;
import com.ragheb.enums.UserRole;
import com.ragheb.mapper.GenericMapper;
import com.ragheb.util.contanst.UserConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements GenericMapper<User> {

    @Override
    public User rowMapper(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong(UserConstant.TABLE_USER_ID);
        String userName = resultSet.getString(UserConstant.TABLE_USER_NAME);
        String userEmail = resultSet.getString(UserConstant.TABLE_USER_EMAIL);
        String userPassword = resultSet.getString(UserConstant.TABLE_USER_PASSWORD);
        String userAddress = resultSet.getString(UserConstant.TABLE_USER_ADDRESS);
        boolean userBlocked = resultSet.getBoolean(UserConstant.TABLE_USER_BLOCK_STATUS);
        UserRole userRole = UserRole.valueOf(resultSet.getString(UserConstant.TABLE_USER_ROLE));

        return new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, userRole);
    }
}
