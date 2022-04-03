package com.geekhub.web.servlets;

import com.geekhub.course.CourseImpl;
import com.geekhub.course.CourseService;
import com.geekhub.dateTime.DateTimeService;
import com.geekhub.exeptions.CourseNotFoundException;
import com.geekhub.lesson.LessonService;
import com.geekhub.person.PersonImpl;
import com.geekhub.person.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = ("/lessons"))
public class LessonsServlet extends HttpServlet {

    private LessonService lessonService;
    private CourseService courseService;
    private DateTimeService dateTimeService;
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.lessonService = new LessonService();
        this.courseService = new CourseService();
        this.dateTimeService = new DateTimeService();
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            int numberLesson = Integer.parseInt(req.getParameter("number-lesson"));

            if (numberLesson == 0) {
                printLessonsList(req, resp, out);
            } else {
                getLesson(req, resp, numberLesson);
            }
        } catch (NumberFormatException e) {
            out.println("Not integer value");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            CourseImpl courseImpl = readCourse(req, resp);

            int numberLesson = Integer.parseInt(req.getParameter("number-lesson"));
            String nameLesson = req.getParameter("name-lesson");
            String description = req.getParameter("description");
            String dateStr = req.getParameter("date");

            LocalDateTime dateTime = dateTimeService.strToLDT(dateStr);

            int lecturerIndex = Integer.parseInt("lecturer-index");

            PersonImpl lecturer = personService.getLecturer(courseImpl, lecturerIndex);

            lessonService.addNewLesson(courseImpl, numberLesson, nameLesson, description, dateTime, lecturer);
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            int index = Integer.parseInt(req.getParameter("number"));
            CourseImpl courseImpl = readCourse(req, resp);
            lessonService.deleteLesson(courseImpl, index);
        } catch (NumberFormatException e) {
            out.println("Not integer value");
        } catch (IndexOutOfBoundsException e) {
            out.println("Course with this number does not exist");
        } catch (CourseNotFoundException e) {
            out.println(e);
        }
    }

    private void printLessonsList(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) {
        try {
            CourseImpl courseImpl = readCourse(req, resp);
            StringBuilder lessonsList = new StringBuilder();
            ArrayList<String> lessons = lessonService.getLessonsList(courseImpl);
            for (String lesson : lessons) {
                lessonsList
                    .append("<p>")
                    .append(lesson)
                    .append("</p>")
                ;
            }
            out.println("<h>" + lessonsList + "</h>");
        } catch (CourseNotFoundException e) {
            out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getLesson(HttpServletRequest req, HttpServletResponse resp, int numberLesson)
        throws IOException {

        PrintWriter out = resp.getWriter();
        try {
            CourseImpl courseImpl = readCourse(req, resp);
            int lessonKey = courseImpl.getIdLessons().get(numberLesson - 1);

            resp.sendRedirect(req.getContextPath() + "/lesson-menu?lesson=" + lessonKey);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CourseNotFoundException e) {
            out.println(e);
        }
    }

    private CourseImpl readCourse(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, CourseNotFoundException {

        int courseIndex = Integer.parseInt(req.getParameter("course-index"));
        return courseService.getCourse(courseIndex);
    }
}
