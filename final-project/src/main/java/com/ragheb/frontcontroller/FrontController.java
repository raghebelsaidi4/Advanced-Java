package com.ragheb.frontcontroller;


import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.controller.ControllerFactory;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;
import com.ragheb.util.contanst.ControllerConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/car-rental")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        LOGGER.info("========================== Car Rental Started ==========================");
    }

    /**
     * @see HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controllerName = request.getParameter(ControllerConstant.CONTROLLER_NAME_VAR);
        try {
            LOGGER.info("Controller Name:: {}", controllerName);
            ControllerFactory factory = new ControllerFactory();
            Controller controller = factory.getController(controllerName);
            ViewResolver resolver = controller.resolve(request, response);
            dispatch(request, response, resolver);
        } catch (ServiceException e) {
            LOGGER.error("Exception in Library Controller", e);
            response.sendRedirect(request.getContextPath() + ControllerConstant.ERROR_PAGE);
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response,
                          ViewResolver resolver) throws ServletException, IOException {

        String view = resolver.getView();
        switch (resolver.getResolveAction()) {
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(view);
                break;
            default:
                response.sendRedirect(request.getContextPath() + ControllerConstant.HOME_PAGE);
        }
    }

    @Override
    public void destroy() {
        LOGGER.info("========================== Car Rental Terminated ==========================");
    }
}
