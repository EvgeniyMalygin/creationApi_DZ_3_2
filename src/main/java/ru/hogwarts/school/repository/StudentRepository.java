package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    Collection<Student> findStudentByFaculty_Id(long id);

    @Query(value = "SELECT count(*) From student", nativeQuery = true)
    Integer numberOfStudentsInSchool();

    @Query(value = "SELECT AVG(age) From student", nativeQuery = true)
    Double averageAgeOfStudent();

    @Query(value = "SELECT id, age, name, faculty_id " +
            "FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<Student> getFiveLastStudents();
}

