package com.ragheb.controller;

import com.ragheb.bean.UserBean;
import com.ragheb.model.UserModel;
import com.ragheb.utility.ServletUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        System.out.println("Operation: " + operation);
        try {
            if (operation != null && operation.equals("logout")) {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                ServletUtility.setSuccessMessage("Logout Successfully", req);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ServletUtility.forward(View.loginView, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = new UserBean();
        String login = req.getParameter("login");
        String pwd = req.getParameter("password");
        HttpSession session = req.getSession(true);
        user = UserModel.UserLogin(login, pwd);
        if (user != null) {
            session.setAttribute("user", user.getFirstName());
            ServletUtility.redirect(View.WelcomeController, req, resp);
        } else {
            ServletUtility.setErrorMessage("Invalid User", req);
            ServletUtility.forward(View.loginView, req, resp);
        }
    }
}
