package com.ragheb.frontcontroller.controller;

import com.ragheb.config.DBConnection;
import com.ragheb.frontcontroller.view.AboutController;
import com.ragheb.frontcontroller.view.BlogController;
import com.ragheb.frontcontroller.view.NewsController;
import com.ragheb.frontcontroller.view.car.CarView;
import com.ragheb.frontcontroller.view.car.CarsController;
import com.ragheb.frontcontroller.view.common.LoginController;
import com.ragheb.frontcontroller.view.common.LogoutController;
import com.ragheb.frontcontroller.view.order.ConfirmOrderController;
import com.ragheb.frontcontroller.view.user.UsersController;
import com.ragheb.service.impl.ServiceFactory;
import com.ragheb.util.contanst.ControllerConstant;

import java.sql.Connection;

public class ControllerFactory {

    private final ServiceFactory serviceFactory = ServiceFactory.INSTANCE;

    public ControllerFactory() {
        Connection connection = new DBConnection().getConnection();
        serviceFactory.setConnection(connection);
    }

    public Controller getController(final String controllerName) {

        switch (controllerName) {
            case ControllerConstant.NEWS_CONTROLLER:
                return new NewsController();
            case ControllerConstant.CARS_CONTROLLER:
                return new CarsController(serviceFactory.getCarService());
            case ControllerConstant.USERS_CONTROLLER:
                return new UsersController(serviceFactory.getUserService());
            case ControllerConstant.ABOUT_CONTROLLER:
                return new AboutController();
            case ControllerConstant.BLOG_CONTROLLER:
                return new BlogController();
            case ControllerConstant.LOGIN_CONTROLLER:
                return new LoginController(serviceFactory.getUserService());
            case ControllerConstant.LOGOUT_CONTROLLER:
                return new LogoutController();
            case ControllerConstant.VIEW_CAR_CONTROLLER:
                return new CarView(serviceFactory.getCarService());
            case ControllerConstant.CONFIRM_ORDER_CONTROLLER:
                return new ConfirmOrderController(serviceFactory.getOrderService(), serviceFactory.getCarService());
            default:
        }
        return null;
    }
}
