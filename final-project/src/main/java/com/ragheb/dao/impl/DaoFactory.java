package com.ragheb.dao.impl;

import java.sql.Connection;


// Enum Singleton
public enum DaoFactory {

    INSTANCE;

    private Connection connection;

    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    public UserDao getUserDao() {
        return new UserDao(connection);
    }

    public CarDao getCarDao() {
        return new CarDao(connection);
    }

    public OrderDao getOrderDao() {
        return new OrderDao(connection);
    }
}
