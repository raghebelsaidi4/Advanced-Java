package com.ragheb.mapper.impl;

import com.ragheb.domain.Order;
import com.ragheb.mapper.GenericMapper;
import com.ragheb.util.contanst.OrderConstant;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements GenericMapper<Order> {

    @Override
    public Order rowMapper(ResultSet resultSet) throws SQLException {

        long orderId = resultSet.getLong(OrderConstant.TABLE_ORDER_ID);
        long userId = resultSet.getLong(OrderConstant.TABLE_ORDER_USER_ID);
        long carId = resultSet.getLong(OrderConstant.TABLE_ORDER_CAR_ID);
        Date orderDate = resultSet.getDate(OrderConstant.TABLE_ORDER_DATE);
        Date returningDate = resultSet.getDate(OrderConstant.TABLE_ORDER_RETURN_DATE);
        boolean carReturned = resultSet.getBoolean(OrderConstant.TABLE_ORDER_CAR_RETURNED);
        double rentalCost = resultSet.getDouble(OrderConstant.TABLE_ORDER_RENTAL_COST);

        return new Order(orderId, userId, carId, orderDate, returningDate, carReturned, rentalCost);

    }
}