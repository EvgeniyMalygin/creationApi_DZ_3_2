package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotFountException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    Object flag = new Object();

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
    }

    public Student creatStudent(Student student) {
        logger.info("Запущен метод creatStudent");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("Запущен метод findStudent");
        return studentRepository.findById(id).orElseThrow(NotFountException::new);
    }

    public Student updateStudent(Student student) {
        logger.info("Запущен метод updateStudent");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Запущен метод deleteStudent");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudent() {
        logger.info("Запущен метод getAllStudent");
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentOfAge(int age) {
        logger.info("Запущен метод getStudentOfAge");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getStudentAgeBetweenMinMax(int min, int max) {
        logger.info("Запущен метод getStudentAgeBetweenMinMax");
        if (min < 0 || max < 0 || min > max) {
            logger.error("Заданы неверные аргументы min: " + min + ", max: " + max);
            throw new IllegalArgumentException();
        }
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getNumberFacultyOfStudent(long student_id) {
        logger.info("Запущен метод getNumberFacultyOfStudent");
        return studentRepository.findById(student_id).get().getFaculty();
    }

    public int numberOfStudentsInSchool() {
        logger.info("Запущен метод numberOfStudentsInSchool");
        return studentRepository.numberOfStudentsInSchool();
    }

    public double averageAgeOfStudent() {
        logger.info("Запущен метод averageAgeOfStudent");
        return studentRepository.averageAgeOfStudent();
    }

    public Collection<Student> getFiveLastStudents() {
        logger.info("Запущен метод getFiveLastStudents");
        return studentRepository.getFiveLastStudents();
    }

    public Collection<String> getStudentWithNameOfA() {
        return studentRepository.findAll().stream().filter(st -> st.getName().toUpperCase().charAt(0) == 'А')
                .sorted(new StudentComparator()).map(Student::getName).collect(Collectors.toList());
    }

    public int averageAgeOfStudentStream() {
        List<Student> tempList = new ArrayList<>(studentRepository.findAll());
        return tempList.stream().map(Student::getAge).reduce(0, (a, b) -> a + b) / tempList.size();
    }

    public void getStudentThread() {
        ArrayList<Student> tempList = new ArrayList<>(studentRepository.findAll());

        printStudent(tempList.get(0).getName());
        printStudent(tempList.get(1).getName());

        new Thread(() -> {
            printStudent(tempList.get(2).getName());
            printStudent(tempList.get(3).getName());
        }).start();

        new Thread(() -> {
            printStudent(tempList.get(4).getName());
            printStudent(tempList.get(5).getName());
        }).start();
    }

    public void printStudent(String name) {
        System.out.println(name);
        String s = "";
        for (int i = 0; i < 10000; i++) {  //без задержки имена выводяться без изменения порядка
            s += i;
        }
    }

    public void getStudentThreadSynchronized() {
        ArrayList<Student> tempList = new ArrayList<>(studentRepository.findAll());

        printStudentSynchronized(tempList.get(0).getName());
        printStudentSynchronized(tempList.get(1).getName());

        new Thread(() -> {
            printStudentSynchronized(tempList.get(2).getName());
            printStudentSynchronized(tempList.get(3).getName());
        }).start();

        new Thread(() -> {
            printStudentSynchronized(tempList.get(4).getName());
            printStudentSynchronized(tempList.get(5).getName());
        }).start();
    }

    public void printStudentSynchronized(String name) {
        synchronized (flag) {
            System.out.println(name);
        }
        String s = "";
        for (int i = 0; i < 10000; i++) {  //без задержки имена выводяться без изменения порядка
            s += i;
        }
    }
}
