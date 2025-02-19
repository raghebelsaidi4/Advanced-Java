package com.ragheb.frontcontroller.view.car;

import com.ragheb.domain.Car;
import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.service.impl.CarService;
import com.ragheb.util.contanst.CarConstant;
import com.ragheb.util.contanst.ControllerConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarView implements Controller {

    private final CarService carService;

    public CarView(CarService carService) {
        this.carService = carService;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServiceException {

        String carId = request.getParameter(CarConstant.CAR_ID);

        Car car = carService.getItemById(Long.parseLong(carId));

        request.setAttribute(ControllerConstant.CAR_RESPONSE, car);

        return new ViewResolver(ControllerConstant.CAR_PAGE);
    }
}
