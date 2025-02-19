package com.ragheb.service.impl;

import com.ragheb.dao.impl.DaoFactory;
import java.sql.Connection;

/**
 * ServiceFactory follows the Singleton pattern using an enum.
 * It provides access to service-layer instances and manages DAO connections.
 */
public enum ServiceFactory {

    INSTANCE;

    private final DaoFactory daoFactory = DaoFactory.INSTANCE;

    private UserService userService;
    private CarService carService;
    private OrderService orderService;

    /**
     * Sets the connection for the DAO factory.
     * Ensure this is called before retrieving any services.
     *
     * @param connection the database connection
     */
    public void setConnection(Connection connection) {
        daoFactory.setConnection(connection);
    }

    /**
     * Returns a singleton instance of UserService.
     *
     * @return UserService instance
     */
    public UserService getUserService() {
        if (userService == null) {
            userService = new UserService(daoFactory.getUserDao());
        }
        return userService;
    }

    /**
     * Returns a singleton instance of CarService.
     *
     * @return CarService instance
     */
    public CarService getCarService() {
        if (carService == null) {
            carService = new CarService(daoFactory.getCarDao());
        }
        return carService;
    }

    /**
     * Returns a singleton instance of OrderService.
     *
     * @return OrderService instance
     */
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderService(daoFactory.getOrderDao());
        }
        return orderService;
    }
}
