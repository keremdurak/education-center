package com.keremdurak.javadeveloperchallenge.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "instructor")
@ApiModel(value = "Instructor Model")
data class Instructor(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @ApiModelProperty(value = "Instructor ID")
        val id: String? = "",
        @ApiModelProperty(value = "Instructor Name")
        val instructorName: String?,
        @ApiModelProperty(value = "Instructor Surname")
        val instructorSurname: String?,

        @ApiModelProperty(value = "Instructor Course Info")
        @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
        @Fetch(value = FetchMode.SELECT)
        val course: Set<Course> = HashSet()
) {
    constructor(name: String, surname: String) : this(
            "",
            instructorName = name,
            instructorSurname = surname
    )

    constructor(instructorId: String, name: String, surname: String) : this(
            id = instructorId,
            instructorName = name,
            instructorSurname = surname
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Instructor

        if (id != other.id) return false
        if (instructorName != other.instructorName) return false
        if (instructorSurname != other.instructorSurname) return false
        if (course != other.course) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (instructorName?.hashCode() ?: 0)
        result = 31 * result + (instructorSurname?.hashCode() ?: 0)
        /* course devredışı bırakılmasının sebebi instructor içinde birden fazla course olduğunda
        StackOverFlow hatasına sebebiyet veriyor.
        */
        // result = 31 * result + (course?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Instructor(id=$id, instructorName=$instructorName, instructorSurname=$instructorSurname, course=$course)"
    }


}