package com.yearup.demo.controllers;


import com.yearup.demo.models.Course;
import com.yearup.demo.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // get all
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    // get by id
    @GetMapping("{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }

    // post
    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // put
    @PutMapping("{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable long id) {
        courseService.updateCourse(course, id);
    }

    // delete
    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable long id) {
        courseService.deleteCourseById(id);
    }
}
