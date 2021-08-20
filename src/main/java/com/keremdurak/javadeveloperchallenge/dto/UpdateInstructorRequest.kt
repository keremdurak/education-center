package com.keremdurak.javadeveloperchallenge.dto

data class UpdateInstructorRequest(
        val id: String?,
        val instructorName: String?,
        val instructorSurname: String?
)