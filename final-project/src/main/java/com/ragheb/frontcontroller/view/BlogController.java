package com.ragheb.frontcontroller.view;

import com.ragheb.frontcontroller.controller.Controller;
import com.ragheb.frontcontroller.viewresolve.ViewResolver;
import com.ragheb.util.contanst.ControllerConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogController implements Controller {
    @Override
    public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
        request.setAttribute("blog_post", "Blog Post");
        return new ViewResolver(ControllerConstant.BLOG_PAGE);
    }
}
