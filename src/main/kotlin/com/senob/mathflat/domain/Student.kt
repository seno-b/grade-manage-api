package com.senob.mathflat.domain

import javax.persistence.*

@Entity
class Student(name: String, grade: Int, schoolName: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 20)
    var name: String = name

    @Column(length = 2)
    var grade: Int = grade

    @Column(length = 20)
    var schoolName: String = schoolName

    @OneToMany(mappedBy = "student")
    lateinit var classRooms: List<StudentClassRoom>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Student(id=$id, studentName='$name', grade=$grade, schoolName='$schoolName')"
    }
}