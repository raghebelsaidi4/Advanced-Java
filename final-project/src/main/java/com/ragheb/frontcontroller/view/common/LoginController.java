package com.ragheb.frontcontroller.view.common;

import com.ragheb.domain.User;
import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.service.impl.UserService;
import com.ragheb.util.contanst.ControllerConstant;
import com.ragheb.util.contanst.UserConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException {

        String page;
        ViewResolver viewResolver = new ViewResolver();
        HttpSession session = request.getSession();

        String login = request.getParameter(UserConstant.USER_LOGIN);
        String password = request.getParameter(UserConstant.USER_PASSWORD);

        User user = userService.getUserByUserNameAndPassword(login, password);

        if (null != user) {
            session.setAttribute(UserConstant.USER_ATTRIBUTE, user);

            if (user.isUserBlocked()) {
                request.setAttribute(UserConstant.BLOCK_MESSAGE, "User Blocked");
                page = ControllerConstant.LOGIN_PAGE;
            }else {
                page = ControllerConstant.USER_PROFILE;
            }

        } else {
            request.setAttribute(UserConstant.INVALID_LOGIN, "Invalid Login Credintials");
            page = ControllerConstant.LOGIN_PAGE;
        }
        viewResolver.forward(page);
        return viewResolver;
    }
}
