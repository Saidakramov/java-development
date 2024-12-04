package com.yearup.demo.controllers;

import com.yearup.demo.models.Student;
import com.yearup.demo.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // get students by id
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(long id) {
        Student studentFound = studentService.getStudentById(id);

        if (studentFound == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentFound);
    }

    // add a student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if (student.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // update a student
    @PutMapping("{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable long id) {
        boolean success = studentService.updateStudent(student, id);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete a student
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }


    // find student by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Student>> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentsByName(name));
    }

}
