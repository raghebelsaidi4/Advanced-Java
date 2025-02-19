package com.ragheb.frontcontroller.view.order;

import com.ragheb.domain.Car;
import com.ragheb.domain.Order;
import com.ragheb.domain.User;
import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.entitybuilder.OrderBuilderFromRequest;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.service.impl.CarService;
import com.ragheb.service.impl.OrderService;
import com.ragheb.util.contanst.CarConstant;
import com.ragheb.util.contanst.ControllerConstant;
import com.ragheb.util.contanst.UserConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmOrderController implements Controller {

    private final OrderService orderService;
    private final CarService carService;
    private final OrderBuilderFromRequest orderBuilder;

    public ConfirmOrderController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;
        orderBuilder = new OrderBuilderFromRequest();
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String carId = request.getParameter(CarConstant.CAR_ID);
        long carID = Long.parseLong(carId);
        Car car = carService.getItemById(carID);

        User user = (User) request.getSession(false).getAttribute(UserConstant.USER_ATTRIBUTE);
        if (user != null) {

            Order order = orderBuilder.buildUserOrder(request, user.getUserId(), carID);
            int insertOrder = orderService.insertItem(order);
            if(insertOrder == 1) {
                request.setAttribute(ControllerConstant.ORDER_SAVED, "Order Saved");
            }else {
                request.setAttribute(ControllerConstant.ORDER_FAILED, "Order Failed");
            }

        } else {
            request.setAttribute(UserConstant.INVALID_LOGIN, "Invalid Login Credentials");
        }
        request.setAttribute(ControllerConstant.CAR_RESPONSE, car);
        return new ViewResolver(ControllerConstant.CAR_PAGE);
    }
}
