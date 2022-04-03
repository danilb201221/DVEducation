package com.geekhub.web.servlets;

import com.geekhub.courseImpl.CourseService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/courseImpl-menu"})
public class CourseMenuServlet extends HttpServlet {

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

        out.println("""
            <h>
            What would you like to do? Choose the option you want:<br><br>
            Show all lectures (number and name)<br>
            Add new lessonImpl<br>
            Delete lessonImpl by number<br>
            Get lessonImpl<br>
            Show all student in this courseImpl<br>
            Add new student in this courseImpl<br>
            Delete student in this courseImpl<br>
            Add many new student in this courseImpl<br>
            Add new lecturer in this courseImpl<br>
            Delete lecturer in this courseImpl<br>
            </h>""");
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

}
