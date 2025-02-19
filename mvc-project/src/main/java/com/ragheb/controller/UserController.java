package com.ragheb.controller;

import com.ragheb.bean.UserBean;
import com.ragheb.model.UserModel;
import com.ragheb.utility.DataUtility;
import com.ragheb.utility.ServletUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    public UserController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(View.registerView);
//        requestDispatcher.forward(req, resp);

        //Edit
        UserModel userModel = new UserModel();
        long id = DataUtility.getLong(req.getParameter("id"));
        if (id > 0) {
            UserBean bean = null;
            bean = userModel.FindByPk(id);
            req.setAttribute("user", bean);
        }
        ServletUtility.forward(View.registerView, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = new UserBean();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setDob(DataUtility.getDate(req.getParameter("dob")));
        user.setMobileNo(req.getParameter("mobile"));

        user.setId(DataUtility.getLong(req.getParameter("id")));
        if (user.getId() > 0) {
            // update records
            long i = UserModel.UpdateUser(user);
            if (i > 0) {
                ServletUtility.setSuccessMessage("User Update Successfully", req);
            } else {
                ServletUtility.setErrorMessage("User Update Failed", req);
            }
        } else {
            long i = UserModel.addUser(user);
            if (i > 0) {
                ServletUtility.setSuccessMessage("User register successfully", req);

            } else {
                ServletUtility.setErrorMessage("Not inserted", req);
            }
        }
        req.getRequestDispatcher(View.registerView).forward(req, resp);
    }
}
