package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotFountException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {

        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }


    public Faculty creatFaculty(Faculty faculty) {
        logger.info("Запущен метод creatFaculty");
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Запущен метод updateFaculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Запущен метод findFaculty");
        return facultyRepository.findById(id).orElseThrow(NotFountException::new);
    }

    public void deleteFaculty(long id) {
        logger.info("Запущен метод deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculty() {
        logger.info("Запущен метод getAllFaculty");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyOfColor(String color) {
        logger.info("Запущен метод getFacultyOfColor");
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getFacultyOfColorIgnorCase(String color) {
        logger.info("Запущен метод getFacultyOfColorIgnorCase");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> getFacultyOfNameIgnorCase(String name) {
        logger.info("Запущен метод getFacultyOfNameIgnorCase");
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> getStudentOfFaculte(long temp_id) {
        logger.info("Запущен метод getStudentOfFaculte");
        return studentRepository.findStudentByFaculty_Id(temp_id);
    }

    public String getLongestTitleOfFaculty() {
        return facultyRepository.findAll().stream().map(Faculty::getName).max(Comparator.comparing(String::length)).toString();
    }
}
