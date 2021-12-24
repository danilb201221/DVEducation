package lesson;

import homework.HomeWork;
import person.Person;
import resource.Resource;
import person.LecturersRepository;
import person.LecturersRepositoryImpl;
import resource.ResourceRepository;
import resource.ResourceRepositoryImpl;
import MainConsole;

public class LessonServiceImpl implements LessonService {

    MainConsole console = new MainConsole();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    LecturersRepository lecturersRepository = new LecturersRepositoryImpl();

    private Lesson lesson;

    public LessonServiceImpl() {
        this.lesson = new Lesson();
    }

    @Override
    public String toString () {
        String toString = "Number: " + lesson.getNum() + ". Name: " + lesson.getName();
        return toString;
    }

    private void printMenuLesson() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Get information of this lesson\n"
            + "2. Show all resources\n"
            + "3. Add new resource\n"
            + "4. Add many resources\n"
            + "5. Get resource by number\n"
            + "6. Back");
    }

    @Override
    public void menuLesson(Lesson lesson) {
        int countMenu;
        do {
            printMenuLesson();
            countMenu = console.getInt();
            switch (countMenu) {
                case 1:
                    System.out.println("You chose get information of this lesson");
                    lesson.toString();
                case 2:
                    System.out.println("You chose show all resources");
                    resourceRepository.printAllResources();
                    break;
                case 3:
                    System.out.println("You chose add new resource");
                    resourceRepository.addNewResource();
                    break;
                case 4:
                    System.out.println("You chose add many resources");
                    addManyResources();
                    break;
                case 5:
                    System.out.println("You chose get resource by number");
                    resourceRepository.getResourceByNumber();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("This command is not available, select from the list provided");
                    break;
            }
        } while (countMenu == 6);
    }

    public void addManyResources () {
        System.out.println("How many resources you want add?");
        for (int i = 0; i < console.getInt(); i++) {
            resourceRepository.addNewResource();
        }
    }

    @Override
    public Lesson addNewLessonByNumber(int num) {
        System.out.println("Add name lesson");
        String name = console.getString();
        System.out.println("Add description lesson");
        String description = console.getString();
        System.out.println("Add date lesson");
        String date = console.getString();
        Resource[] resources = new Resource[20];
        System.out.println("Add lecturer from the list");
        Person lecturer = lecturersRepository.addLecturerFromList();
        System.out.println("Add homework");
        HomeWork homeWork = new HomeWork();
        lesson = new Lesson(num, name, description, date, resources, lecturer, homeWork);
        return lesson;
    }
}