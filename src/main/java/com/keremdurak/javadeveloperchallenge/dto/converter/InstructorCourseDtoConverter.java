package com.keremdurak.javadeveloperchallenge.dto.converter;

import com.keremdurak.javadeveloperchallenge.dto.InstructorCourseDto;
import com.keremdurak.javadeveloperchallenge.model.Course;
import org.springframework.stereotype.Component;

@Component
public class InstructorCourseDtoConverter {

    public InstructorCourseDto convert(Course from) {
        return new InstructorCourseDto(
                from.getId(),
                from.getCourseName()
        );
    }
}
