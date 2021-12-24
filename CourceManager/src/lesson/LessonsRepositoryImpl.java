package lesson;

import MainConsole;

public class LessonsRepositoryImpl implements LessonsRepository {

    MainConsole console = new MainConsole();
    LessonService lesson = new LessonServiceImpl();

    private Lesson[] lessons;

    public LessonsRepositoryImpl() {
        this.lessons = new Lesson[100];
    }

    @Override
    public void printAllLessons() {
        for (int i = 0; i < lessons.length; i++) {
            if ((lessons[i] != null)) {
                System.out.println(lessons[i].toString());
            }
        }
    }

    @Override
    public void addNewLessonByNumber() {
        System.out.println("Add number lesson");
        int num = console.getInt();
        if (lessons[num-1] == null) {
            lessons[num-1] = lesson.addNewLessonByNumber(num-1);
        } else {
            System.out.println("This number used");
        }
    }

    @Override
    public void delLessonByNumber() {
        System.out.println("Enter the number of the lesson you want to delete");
        int num = console.getInt();
        lessons[num-1] = null;
        System.out.println("Lesson №" + num + " deleted");
    }

    @Override
    public void getLessonByNumber() {
        int num = console.getInt();
        lesson.menuLesson(lessons[num-1]);
    }

@Override
    public Lesson[] getLessons() {
        return lessons;
    }
}
