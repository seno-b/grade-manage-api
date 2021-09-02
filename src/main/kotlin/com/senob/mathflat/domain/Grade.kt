package com.senob.mathflat.domain

import javax.persistence.*

@Entity
class Grade(score: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var score: Int = score

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    lateinit var student: Student

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    lateinit var subject: Subject

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Grade

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Grade(id=$id, score=$score)"
    }


}
