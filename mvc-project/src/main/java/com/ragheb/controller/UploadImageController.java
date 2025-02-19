package com.ragheb.controller;

import com.ragheb.utility.ServletUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;

//@WebServlet(name = "UploadImageController", urlPatterns = {"/UploadImageController"})
@MultipartConfig(maxFileSize = 169999999)
public class UploadImageController extends HttpServlet {

    public UploadImageController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtility.forward(View.uploadImageView, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = null;
        try {
            part = req.getPart("photo");
        } catch (IOException | ServletException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String imageName = ServletUtility.UploadImage(req, resp, fileName);
        System.out.println("Image Name: " + imageName);
    }
}
