package com.yearup.demo.services;

import com.yearup.demo.models.Course;
import com.yearup.demo.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // get a course by id
    public Course getCourseById(long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        }
        return null;
    }

    // delete a course
    public void deleteCourseById(long id) {
        Course course = getCourseById(id);
        if (course != null) {
            courseRepository.delete(course);
        }
    }

    // update a product
    public void updateCourse(Course course, long id) {
        Course courseToBeUpdated = getCourseById(id);
        courseToBeUpdated.setName(course.getName());
        courseToBeUpdated.setDescription(course.getDescription());
        courseToBeUpdated.setAvgGrade(course.getAvgGrade());
        courseRepository.save(courseToBeUpdated);
    }

    // adding a course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
