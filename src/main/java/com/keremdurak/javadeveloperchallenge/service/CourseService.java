package com.keremdurak.javadeveloperchallenge.service;

import com.keremdurak.javadeveloperchallenge.dto.CourseDto;
import com.keremdurak.javadeveloperchallenge.dto.CreateCourseRequest;
import com.keremdurak.javadeveloperchallenge.dto.UpdateCourseRequest;
import com.keremdurak.javadeveloperchallenge.dto.converter.CourseDtoConverter;
import com.keremdurak.javadeveloperchallenge.exception.CourseNotFoundException;
import com.keremdurak.javadeveloperchallenge.model.Course;
import com.keremdurak.javadeveloperchallenge.model.Instructor;
import com.keremdurak.javadeveloperchallenge.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorService instructorService;
    private final CourseDtoConverter converter;

    public CourseService(CourseRepository courseRepository,
                         InstructorService instructorService,
                         CourseDtoConverter converter) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
        this.converter = converter;
    }


    public List<CourseDto> getAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public CourseDto getCourseById(String id) {
        return converter.convert(findCourseById(id));

    }

    public CourseDto createCourse(CreateCourseRequest request) {

        Instructor instructor = instructorService.findInstructorById(request.getInstructorId());

        Course course = new Course(
                request.getCourseName(),
                instructor);

        return converter.convert(courseRepository.save(course));
    }

    public CourseDto updateCourse(String id, UpdateCourseRequest request) {

        Course course = findCourseById(id);

        Course updatedCourse = new Course(
                course.getId(),
                request.getCourseName(),
                course.getInstructor()
        );
        return converter.convert(courseRepository.save(updatedCourse));
    }

    public void deleteCourse(String id) {

        findCourseById(id);
        try {
            courseRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new CourseNotFoundException("Course could not delete");
        }

    }

    protected Course findCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(
                        () -> new CourseNotFoundException("Course could not find by id: " + id)
                );
    }


}
