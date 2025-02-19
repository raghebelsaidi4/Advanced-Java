package com.ragheb.frontcontroller.view.car;

import com.ragheb.domain.Car;
import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.service.impl.CarService;
import com.ragheb.util.contanst.ControllerConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CarsController implements Controller {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        List<Car> cars = carService.getAllItems();
        request.setAttribute(ControllerConstant.CARS_RESPONSE, cars);
        return new ViewResolver(ControllerConstant.CARS_PAGE);
    }
}
