package com.senob.mathflat.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

class StudentDto(name: String, schoolName: String, grade: Int) {

    var id: Long? = null

    @field:NotEmpty(message = "name은 필수 값 입니다.")
    var name: String = name

    @field:NotEmpty(message = "schoolName은 필수 값 입니다.")
    var schoolName: String = schoolName

    @field:Positive(message = "grade는 필수 값 입니다.")
    var grade: Int = grade
}