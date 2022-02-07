package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.course.CourseService;

public class CourseConsole {

    MainConsole mainConsole = new MainConsole();
    CourseService courseService = new CourseService();

    public void displayCoursesList() {
        System.out.println(courseService.getCoursesList());
    }

    public void addNewCourse() {
        System.out.println("Add name course");
        String name = mainConsole.getString();
        courseService.addNewCourse(name);
    }

    public void delCourse() {
        System.out.println("Enter the number of the course you want to delete");
        int id = mainConsole.getInt()-1;
        courseService.delCourse(id);
    }

    public Course getCourse() {
        System.out.println("Enter the number of the course you want to get");
        int id = mainConsole.getInt()-1;
        return courseService.getCourseByNumber(id);
    }
}
