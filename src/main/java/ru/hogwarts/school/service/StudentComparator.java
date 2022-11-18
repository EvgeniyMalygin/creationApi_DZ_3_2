package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    public int compare(Student st1, Student st2) {
        return st1.getName().toUpperCase().compareTo(st2.getName().toUpperCase());
    }
}
