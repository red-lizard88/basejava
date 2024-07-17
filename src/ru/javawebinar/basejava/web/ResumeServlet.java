package ru.javawebinar.basejava.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name==null){
            response.getWriter().write("Hello resumes");
        }
        else
        response.getWriter().write("Hello "+name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
