package com.senob.mathflat.dto

import javax.validation.constraints.Positive

class GradeDto(score: Int) {

    var id: Long? = null

    @field:Positive(message = "score는 0보다 작을 수 없습니다.")
    var score: Int = score

    var studentId: Long? = null
    var subjectId: Long? = null
}
