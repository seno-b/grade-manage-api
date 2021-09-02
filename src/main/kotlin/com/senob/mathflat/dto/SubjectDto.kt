package com.senob.mathflat.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

class SubjectDto(classId: Long, name: String) {

    var id: Long? = null

    @field:Positive(message = "classId는 필수 값 입니다.")
    var classId: Long = classId

    @field:NotEmpty(message = "name은 필수 값 입니다.")
    var name: String = name
}
