package com.ragheb.frontcontroller.controller;

import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.service.api.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
