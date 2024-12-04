package com.yearup.demo.services;

import com.yearup.demo.models.Student;
import com.yearup.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get students by id
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

    // add a student
    public Student addStudent (Student student) {
        return studentRepository.save(student);
    }

    // update a student
    public boolean updateStudent (Student student, long id) {
        Student studentToBeUpdated = getStudentById(id);

        if (studentToBeUpdated != null) {
            studentToBeUpdated.setName(student.getName());
            studentToBeUpdated.setEmail(student.getEmail());
            studentToBeUpdated.setAge(student.getAge());
            return true;
        } else {
            return false;
        }
    }

    // delete a student
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    // find student by name
    public Optional<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
}
