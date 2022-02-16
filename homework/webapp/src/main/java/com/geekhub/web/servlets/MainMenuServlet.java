package com.geekhub.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/main-menu"})
public class MainMenuServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("""
            <h>         What would you like to do? Choose the option you want:<br><br>
                        <a href="/courses?index=0">Show all courses (number and name)</a><br>
                        Add new course<br>
                        Delete course by number<br>
                        <a href="/courses">Get course by number</a></h>""");
    }
}
