package com.ragheb.controller;

public interface View {

    public String APP_CONTEXT = "/mvc";
    public String PAGE_FOLDER = "/jsp";

    public String loginView = PAGE_FOLDER + "/login.jsp";
    public String registerView = PAGE_FOLDER + "/registration.jsp";
    public String welcomeView = PAGE_FOLDER + "/welcome.jsp";
    public String userViewList = PAGE_FOLDER + "/userViewList.jsp";
    public String uploadImageView = PAGE_FOLDER + "/uploadImage.jsp";

    public String LoginController = APP_CONTEXT + "/LoginController";
    public String UserController = APP_CONTEXT + "/UserController";
    public String WelcomeController = APP_CONTEXT + "/WelcomeController";
    public String UserListController = APP_CONTEXT + "/UserListController";
    public String UploadImageController = APP_CONTEXT + "/UploadImageController";

}
