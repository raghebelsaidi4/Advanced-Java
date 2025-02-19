package com.ragheb.frontcontroller.entitybuilder;

import com.ragheb.domain.Order;
import com.ragheb.util.contanst.OrderConstant;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class OrderBuilderFromRequest {

    /**
     *
     * @param request
     * @param userId
     * @param carId
     * @return Order to store in DB
     */
    public Order buildUserOrder(HttpServletRequest request, long userId, long carId) {

        String orderDate = request.getParameter(OrderConstant.TABLE_ORDER_DATE);
        String returningDate = request.getParameter(OrderConstant.TABLE_ORDER_RETURN_DATE);
        double rentalCost = 20.00;

        return new Order(userId, carId, Date.valueOf(orderDate), Date.valueOf(returningDate), rentalCost);
    }
}
