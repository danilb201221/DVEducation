package com.geekhub.web.servlets;


import com.geekhub.course.CourseService;
import com.geekhub.exeptions.CourseNotFoundException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = ("/courses"))
public class CoursesServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        //TEST BLOCK
        for (int i = 0; i < 5; i++) {
            courseService.addNewCourse("test " + i);
        }
        //TEST BLOCK

        try {
            int index = Integer.parseInt(req.getParameter("index"));

            if (index == 0) {
                printCoursesList(out);
            } else {
                getCourse(req, resp, index);
            }
        } catch (NumberFormatException e) {
            out.println("Not integer value");
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        courseService.addNewCourse(name);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            int index = Integer.parseInt(req.getParameter("number"));
            courseService.deleteCourse(index);
        } catch (NumberFormatException e) {
            out.println("Not integer value");
        } catch (IndexOutOfBoundsException e) {
            out.println("Course with this number does not exist");
        }
    }

    private void getCourse(HttpServletRequest req, HttpServletResponse resp, int index) throws CourseNotFoundException {
        if (courseService.getCourse(index) != null) {
            try {
                resp.sendRedirect(req.getContextPath() + "/course-menu?course=" + index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printCoursesList(PrintWriter out) {
        StringBuilder coursesList = new StringBuilder();
        ArrayList<String> courses = courseService.getCoursesList();
        for (String course : courses) {
            coursesList
                .append("<p>")
                .append(course)
                .append("</p>")
            ;
        }
        out.println("<h>" + coursesList + "</h>");
    }
}
