package com.senob.mathflat.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class ClassRoom(className: String, teacherName: String, startDate: LocalDateTime, endDate: LocalDateTime) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 100)
    var className: String = className

    @Column(length = 20)
    var teacherName: String = teacherName

    var startDate: LocalDateTime = startDate
    var endDate: LocalDateTime = endDate

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClassRoom

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "ClassRoom(id=$id, className='$className', teacherName='$teacherName', startDate=$startDate, endDate=$endDate)"
    }


}