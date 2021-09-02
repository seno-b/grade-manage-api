package com.senob.mathflat.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class ClassRoom(name: String, teacherName: String, startDate: LocalDateTime, endDate: LocalDateTime) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 100)
    var name: String = name

    @Column(length = 20)
    var teacherName: String = teacherName

    var startDate: LocalDateTime = startDate
    var endDate: LocalDateTime = endDate

    @OneToMany(mappedBy = "classRoom")
    lateinit var students: List<StudentClassRoom>

    @OneToMany(mappedBy = "classRoom")
    lateinit var subjects: List<Subject>

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
        return "ClassRoom(id=$id, className='$name', teacherName='$teacherName', startDate=$startDate, endDate=$endDate)"
    }


}