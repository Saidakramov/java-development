package com.yearup.demo.repositories;

import com.yearup.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
