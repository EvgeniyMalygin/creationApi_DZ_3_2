package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudent(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.creatStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Student> getAllStudent() {

        return studentService.getAllStudent();
    }

    @GetMapping(value = "age")
    public ResponseEntity<Collection<Student>> ageOfStudent(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.getStudentOfAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/studentAgeBetween")
    public Collection<Student> getStudentAgeBetweenMinMax(@RequestParam int min, @RequestParam int max) {
        return studentService.getStudentAgeBetweenMinMax(min, max);
    }

    @GetMapping("facultyOfStudent")
    public Faculty getNumberFacultyOfStudent(@RequestParam long id) {
        return studentService.getNumberFacultyOfStudent(id);
    }

    @GetMapping("number-student-in-school")
    public int numberOfStudentsInSchool() {
        return studentService.numberOfStudentsInSchool();
    }

    @GetMapping("average-age-student")
    public double averageAgeOfStudent() {
        return studentService.averageAgeOfStudent();
    }

    @GetMapping("five-last-students")
    public Collection<Student> getFiveLastStudents(){
        return studentService.getFiveLastStudents();

    }

    @GetMapping("/student-name-A")
    public Collection<String> getStudentWithNameOfA() {
        return studentService.getStudentWithNameOfA();
    }

    @GetMapping("/average-age-student-v1")
    public int averageAgeOfStudentStream() {
        return studentService.averageAgeOfStudentStream();
    }
}
