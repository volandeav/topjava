package ru.javawebinar.topjava.web;


import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends javax.servlet.http.HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Users.jsp").forward(request,response);
        log.debug("UserServletRedirect");
    }
}
