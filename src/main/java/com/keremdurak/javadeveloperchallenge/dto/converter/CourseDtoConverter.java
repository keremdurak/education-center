package com.keremdurak.javadeveloperchallenge.dto.converter;

import com.keremdurak.javadeveloperchallenge.dto.CourseDto;
import com.keremdurak.javadeveloperchallenge.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseDtoConverter {

    private final InstructorDtoConverter instructorDtoConverter;

    public CourseDtoConverter(InstructorDtoConverter instructorDtoConverter) {
        this.instructorDtoConverter = instructorDtoConverter;
    }


    public CourseDto convert(Course from) {
        return new CourseDto(from.getId(),
                from.getCourseName(),
                instructorDtoConverter.convertToCourseInstructor(from.getInstructor())
        );
    }
}
