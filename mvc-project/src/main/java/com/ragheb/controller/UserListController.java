package com.ragheb.controller;

import com.ragheb.model.UserModel;
import com.ragheb.utility.DataUtility;
import com.ragheb.utility.ServletUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "UserListController", urlPatterns = {"/UserListController"})
public class UserListController extends HttpServlet {

    public UserListController() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = new UserModel();
        // delete..
        long id= DataUtility.getLong(req.getParameter("id"));
        if(id>0) {
            UserModel.delete(id);
            ServletUtility.setSuccessMessage("Data Deleted Successfully", req);
        }

        List list = null;
        list = userModel.list();
        if (list == null && list.size() == 0) {
            ServletUtility.setErrorMessage("Record Not Found", req);
        }
        ServletUtility.setList(list,req);
        ServletUtility.forward(View.userViewList, req, resp);
    }
}
