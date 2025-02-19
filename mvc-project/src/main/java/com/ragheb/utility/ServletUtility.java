package com.ragheb.utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class provides utility operation for Servlet container like forward,
 * redirect, handle generic exception=same time exception, manage success and
 * error message, manage default Bean and List, manage pagination parameters
 *
 */
public class ServletUtility {

    static String Error = "Invalid data";
    static String SuccessMessage = "Done";

    // forward request...
    public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        System.out.println(page);
        rd.forward(request, response);
    }

    // redirect request
    public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.sendRedirect(page);
    }

    public static void handleException(Exception e, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("exception", e);
        ServletUtility.forward("Error Message", request, response);
        e.printStackTrace();
    }

    public static String getErrorMessage(String property, HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static String getMessage(String property, HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static void setErrorMessage(String msg, HttpServletRequest request) {
        request.setAttribute(Error, msg);
    }

    public static String getErrorMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(Error);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static void setSuccessMessage(String msg, HttpServletRequest request) {
        request.setAttribute(SuccessMessage, msg);
    }

    public static String getSuccessMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(SuccessMessage);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static String getParameter(String property, HttpServletRequest request) {
        String val = (String) request.getParameter(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static void setList(List list, HttpServletRequest request) {
        request.setAttribute("list", list);
    }
    public static List getList(HttpServletRequest request) {
        return (List) request.getAttribute("list");
    }

    public static void setOperation(String msg, HttpServletRequest request) {
        request.setAttribute("Operation", msg);
    }
    public static String getOperation(HttpServletRequest request) {
        String val = (String) request.getAttribute("Operation");
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    public static String UploadImage(HttpServletRequest request, HttpServletResponse response,String name)
            throws ServletException, IOException {
        ResourceBundle rb = ResourceBundle.getBundle("System.properties");
        System.out.println("RB:"+rb.getString("ImagePath"));
        String savePath = "D:\\projects spring\\Advanced-Java\\mvc-project\\src\\main\\webapp\\image";
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        Part part = request.getPart("photo");
        String fileName = extractFileName(part);
        part.write(savePath + File.separator + name+fileName);
        return name+fileName;
    }

    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}
