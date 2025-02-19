package com.ragheb.frontcontroller.view.common;

import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.util.contanst.ControllerConstant;
import com.ragheb.util.contanst.UserConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException {

        ViewResolver viewResolver = new ViewResolver();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(UserConstant.USER_ATTRIBUTE);
            session.invalidate();
        }
        viewResolver.redirect(request.getContextPath() + ControllerConstant.HOME_PAGE);
        return viewResolver;
    }
}
