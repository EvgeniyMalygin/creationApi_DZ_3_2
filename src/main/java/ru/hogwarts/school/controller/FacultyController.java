package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {

        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {

        return facultyService.creatFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Faculty> getAllFaculty() {

        return facultyService.getAllFaculty();
    }

    @GetMapping(value = "color")
    public ResponseEntity<Collection<Faculty>> getFacultyOfColor(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.getFacultyOfColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("/findFacultyByColorOrName")
    public ResponseEntity<Collection<Faculty>> getFacultyOfColorOrName(@RequestParam(required = false) String color,
                                                                       @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.getFacultyOfColorIgnorCase(color));
        }
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(facultyService.getFacultyOfNameIgnorCase(name));
        }
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
    @GetMapping("studentsOfFaculty")
    public ResponseEntity<Collection<Student>> getStudentOfFaculte(@RequestParam long faculte_id){
        return ResponseEntity.ok(facultyService.getStudentOfFaculte(faculte_id));
    }
}
