package com.keremdurak.javadeveloperchallenge.repository;

import com.keremdurak.javadeveloperchallenge.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, String> {
}
