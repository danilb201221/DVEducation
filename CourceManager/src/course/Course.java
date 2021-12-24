package course;

import person.LecturersRepositoryImpl;
import lesson.LessonsRepositoryImpl;
import person.StudentsRepositoryImpl;

public class Course {
    private String name;
    private LessonsRepositoryImpl lessons;
    private StudentsRepositoryImpl students;
    private LecturersRepositoryImpl lecturers;

    public Course() {

        this.lessons = new LessonsRepositoryImpl();
        this.students = new StudentsRepositoryImpl();
        this.lecturers = new LecturersRepositoryImpl();
    }

    public Course(String name) {
        this.name = name;
        this.lessons = new LessonsRepositoryImpl();
        this.students = new StudentsRepositoryImpl();
        this.lecturers = new LecturersRepositoryImpl();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LessonsRepositoryImpl getLessons() {
        return lessons;
    }

    public void setLessons(LessonsRepositoryImpl lessons) {
        this.lessons = lessons;
    }

    public StudentsRepositoryImpl getStudents() {
        return students;
    }

    public void setStudents(StudentsRepositoryImpl students) {
        this.students = students;
    }

    public LecturersRepositoryImpl getLecturers() {
        return lecturers;
    }

    public void setLecturers(LecturersRepositoryImpl lecturers) {
        this.lecturers = lecturers;
    }
}