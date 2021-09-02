package com.senob.mathflat.domain

import javax.persistence.*

@Entity
@Table(name = "student_classroom")
class StudentClassRoom(student: Student, classRoom: ClassRoom) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    var student: Student = student

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    var classRoom: ClassRoom = classRoom

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StudentClassRoom

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "StudentClassRoom(id=$id, student_id=$student.id, class_id=$classRoom.id)"
    }


}