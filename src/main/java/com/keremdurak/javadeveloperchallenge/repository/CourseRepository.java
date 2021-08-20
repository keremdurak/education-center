package com.keremdurak.javadeveloperchallenge.repository;

import com.keremdurak.javadeveloperchallenge.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
