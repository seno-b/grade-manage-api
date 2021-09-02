package com.senob.mathflat.repository

import com.senob.mathflat.domain.Grade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface GradeRepository : JpaRepository<Grade, Long> {

    @Query("select AVG(grade.score) from Grade grade join grade.student student join grade.subject subject join subject.classRoom classroom where classroom.id = :classRoomId and student.id = :studentId")
    fun findGradeAvgByStudentIdAndClassroomId(studentId: Long, classRoomId: Long): Long

    @Query("select AVG(grade.score) from Grade grade join grade.subject subject where subject.id = :subjectId")
    fun findGradeAvgBySubjectId(subjectId: Long): Long
}