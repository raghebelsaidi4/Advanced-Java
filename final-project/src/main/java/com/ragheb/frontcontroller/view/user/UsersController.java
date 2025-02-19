package com.ragheb.frontcontroller.view.user;

import com.ragheb.domain.User;
import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.service.impl.UserService;
import com.ragheb.util.contanst.ControllerConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersController implements Controller {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        List<User> users = userService.getAllItems();
        request.setAttribute(ControllerConstant.USERS_RESPONSE, users);
        return new ViewResolver(ControllerConstant.USERS_PAGE);
    }
}
