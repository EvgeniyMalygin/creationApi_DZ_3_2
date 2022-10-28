package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student findStudent (@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.creatStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping
    public Collection<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/age/{age}")
    public Collection<Student> ageOfStudent(@PathVariable int age) {
        return studentService.getStudentOfAge(age);
    }

}
