package com.keremdurak.javadeveloperchallenge.dto.converter;

import com.keremdurak.javadeveloperchallenge.dto.CourseInstructorDto;
import com.keremdurak.javadeveloperchallenge.dto.InstructorDto;
import com.keremdurak.javadeveloperchallenge.model.Instructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class InstructorDtoConverter {

    private final InstructorCourseDtoConverter instructorCourseDtoConverter;

    public InstructorDtoConverter(InstructorCourseDtoConverter instructorCourseDtoConverter) {
        this.instructorCourseDtoConverter = instructorCourseDtoConverter;
    }

    public CourseInstructorDto convertToCourseInstructor(Instructor from) {
        if (from == null) {
            return new CourseInstructorDto("", "", "");
        }

        return new CourseInstructorDto(from.getId(),
                from.getInstructorName(),
                from.getInstructorSurname());

//        return from.map(i -> new CourseInstructorDto(
//                i.getId(),
//                i.getInstructorName(),
//                i.getInstructorSurname()
//        )).orElse(null);

    }

    public InstructorDto convertToInstructorDto(Instructor from) {

        return new InstructorDto(
                from.getId(),
                from.getInstructorName(),
                from.getInstructorSurname(),
                from.getCourse()
                        .stream()
                        .map(instructorCourseDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }

}
