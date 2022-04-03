package com.geekhub.web.servlets;

import com.geekhub.course.CourseImpl;
import com.geekhub.course.CourseService;
import com.geekhub.exeptions.CourseNotFoundException;
import com.geekhub.person.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = ("/students"))
public class StudentsServlet extends HttpServlet {

    PersonService personService;
    CourseService courseService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.personService = new PersonService();
        this.courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private void getStudent(HttpServletRequest req, HttpServletResponse resp, int numberStudent)
        throws IOException {


    }

    private CourseImpl readCourse(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, CourseNotFoundException {

        int courseIndex = Integer.parseInt(req.getParameter("course-index"));
        return courseService.getCourse(courseIndex);
    }
}
