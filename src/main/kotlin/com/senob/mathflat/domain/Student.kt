package com.senob.mathflat.domain

import javax.persistence.*

@Entity
class Student(studentName: String, grade: Int, schoolName: String, classRooms: List<ClassRoom>) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    var id: Long? = null

    @Column(length = 20)
    var studentName: String = studentName

    @Column(length = 2)
    var grade: Int = grade

    @Column(length = 20)
    var schoolName: String = schoolName

    @ManyToMany
    @JoinTable(name = "student_classroom",
        joinColumns = arrayOf(JoinColumn(name = "student_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "class_id"))
    )
    var classRooms: List<ClassRoom> = classRooms

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
        return "Student(id=$id, studentName='$studentName', grade=$grade, schoolName='$schoolName')"
    }


}