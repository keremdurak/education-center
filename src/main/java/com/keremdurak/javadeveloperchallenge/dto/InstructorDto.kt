package com.keremdurak.javadeveloperchallenge.dto

data class InstructorDto(
        val id: String?,
        val instructorName: String?,
        val instructorSurname: String?,
        val course: Set<InstructorCourseDto>?
)
