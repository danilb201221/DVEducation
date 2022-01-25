package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.course.CourseService;

public class CourseConsole {

private final ScannerHelper scannerHelper;
private final CourseService courseService;

    public CourseConsole(ScannerHelper scannerHelper, CourseService courseService) {
        this.scannerHelper = scannerHelper;
        this.courseService = courseService;
    }

    public void displayCoursesList() {
        System.out.println(courseService.getCoursesList());
    }

    public void addNewCourse() {
        System.out.println("Add name course");
        String name = scannerHelper.getString();
        courseService.addNewCourse(name);
    }

    public void deleteCourse() {
        System.out.println("Enter the number of the course you want to delete");
        int id = scannerHelper.getInt()-1;
        courseService.deleteCourse(id);
    }

    public Course getCourse() {
        System.out.println("Enter the number of the course you want to get");
        int id = scannerHelper.getInt()-1;
        return courseService.getCourseByNumber(id);
    }
}
