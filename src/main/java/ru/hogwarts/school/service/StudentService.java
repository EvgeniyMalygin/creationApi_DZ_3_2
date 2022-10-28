package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {

    private final Map<Long, Student> studentMap = new HashMap<>();

    private long lastId = 0;

    public Student creatStudent(Student student) {
        student.setId(lastId++);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(long id, Student student) {
        if(!studentMap.containsKey(id)){
            return null;
        }
        studentMap.put(id, student);
        return student;
    }

    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    public Student deleteStudent(long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> getAllStudent() {
        return studentMap.values();
    }

    public Collection<Student> getStudentOfAge(int age) {
        List<Student> tempList = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getAge() == age) {
                tempList.add(student);
            }
        }
        return tempList;
    }
}
