SELECT student.name as student, student.age as age, faculty.name as faculty
FROM student INNER JOIN faculty ON student.faculty_id = faculty.id;

SELECT student.name as student, student.age as age
FROM student RIGHT JOIN avatar ON student.id = avatar.student_id;