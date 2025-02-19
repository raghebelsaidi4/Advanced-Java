package com.ragheb.dao.impl;

import com.ragheb.dao.api.AbstractDao;
import com.ragheb.dao.api.DaoException;
import com.ragheb.domain.Order;
import com.ragheb.mapper.impl.OrderMapper;
import com.ragheb.util.contanst.OrderConstant;

import java.sql.*;
import java.util.List;

public class OrderDao extends AbstractDao<Order> {

    OrderDao() {
    }

    OrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public int insertItem(Order order) throws DaoException {

        String isReturned = order.isCarReturned() ? "1" : "0";

        String[] orderInfo = { String.valueOf(order.getUserId()), String.valueOf(order.getCarId()),
                String.valueOf(order.getOrderDate()), String.valueOf(order.getReturnDate()), isReturned,
                String.valueOf(order.getRentalCost()) };
        return executeUpdate(OrderConstant.INSERT_ORDER, orderInfo);
    }

    @Override
    public List<Order> getAllItems() throws DaoException {
        return queryForObjects(OrderConstant.SELECT_ALL_ORDERS, new OrderMapper());
    }

    @Override
    public Order getItemById(long id) throws DaoException {
        return queryForObject(OrderConstant.SELECT_ORDER_BY_ID, new OrderMapper(), String.valueOf(id));
    }

    @Override
    public int updateItem(Order order) throws DaoException {

        String isReturned = order.isCarReturned() ? "1" : "0";

        String[] orderInfo = { String.valueOf(order.getUserId()), String.valueOf(order.getCarId()),
                String.valueOf(order.getOrderDate()), String.valueOf(order.getReturnDate()), isReturned,
                String.valueOf(order.getRentalCost()), String.valueOf(order.getOrderId()) };
        return executeUpdate(OrderConstant.UPDATE_ORDER, orderInfo);
    }

    @Override
    public int deleteItem(long id) throws DaoException {
        return executeUpdate(OrderConstant.DELETE_ORDER_BY_ID, String.valueOf(id));
    }
}
