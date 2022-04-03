package com.geekhub;

import com.geekhub.course.CourseImpl;
import com.geekhub.course.CourseService;
import com.geekhub.exeptions.CourseNotFoundException;

public class CourseConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    CourseService courseService = new CourseService();

    public void displayCoursesList() {
        for (int i = 0; i < courseService.getCoursesList().size(); i++) {
            System.out.println(courseService.getCoursesList().get(i));

        }
    }

    public void addNewCourse() {
        System.out.println("Add name course");
        String nameCourse = scannerHelper.getString();
        try {
            courseService.addNewCourse(nameCourse);
        } catch (Exception e) {
            System.err.println("Unexpected error");
        }
    }

    public void deleteCourse() throws IndexOutOfBoundsException, UnsupportedOperationException {
        System.out.println("Enter the number of the course you want to delete");
        int index = scannerHelper.getInt() - 1;
        try {
            courseService.deleteCourse(index);
            System.out.println("Course deleted");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Course with this number does not exist");
        } catch (Exception e) {
            System.err.println("Unexpected error");
        }
    }

    public CourseImpl getCourse() throws NullPointerException, IndexOutOfBoundsException, CourseNotFoundException {
        CourseImpl courseImpl;
        System.out.println("Enter the number of the course you want to get");
        int index = scannerHelper.getInt() - 1;
        courseImpl = courseService.getCourse(index);
        return courseImpl;
    }
}
