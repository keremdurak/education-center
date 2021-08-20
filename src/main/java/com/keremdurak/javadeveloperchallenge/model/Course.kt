package com.keremdurak.javadeveloperchallenge.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "course")
@ApiModel(value = "Course Model")
data class Course(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @ApiModelProperty(value = "Course ID")
        val id: String? = "",
        @ApiModelProperty(value = "Course Name")
        val courseName: String?,

        @ApiModelProperty(value = "Course Instructor Info")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "instructor_id", nullable = false)
        @Fetch(value = FetchMode.SELECT)
        val instructor: Instructor?
) {
    constructor(courseNames: String, instructorName: Instructor) : this(
            courseName = courseNames,
            instructor = instructorName
    ) {

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Course

        if (id != other.id) return false
        if (courseName != other.courseName) return false
        if (instructor != other.instructor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (courseName?.hashCode() ?: 0)
        result = 31 * result + (instructor?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Course(id=$id, courseName=$courseName, instructor=$instructor)"
    }

}