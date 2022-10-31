package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotFountException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {

   private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty creatFaculty(Faculty faculty) {
                return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(()-> new NotFountException());
    }

    public void deleteFaculty(long id){
    facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculty() {

        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyOfColor(String color) {
               return facultyRepository.findByColor(color);
    }
}
