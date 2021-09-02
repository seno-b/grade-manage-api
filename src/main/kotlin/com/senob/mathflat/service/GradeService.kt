package com.senob.mathflat.service

import com.senob.mathflat.domain.Grade
import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class GradeService(val gradeRepository: GradeRepository, val studentRepository: StudentRepository, val subjectRepository: SubjectRepository){
    fun addGrade(subjectId: Long, studentId: Long, gradeDto: GradeDto): GradeDto {
        val findStudent = studentRepository.findById(studentId).get()
        val findSubject = subjectRepository.findById(subjectId).get()
        val grade = Grade(gradeDto.score)
        grade.student = findStudent
        grade.subject = findSubject

        gradeRepository.save(grade)
        gradeDto.id = grade.id
        gradeDto.subjectId = subjectId
        gradeDto.studentId = studentId

        return gradeDto
    }

    fun updateGrade(id: Long, gradeDto: GradeDto): GradeDto {

        // 특정 과목 점수 조회
        val findGrade = gradeRepository.findById(id).get()

        // 과목 점수 수정
        findGrade.score = gradeDto.score
        gradeRepository.save(findGrade)

        gradeDto.id = findGrade.id
        gradeDto.studentId = findGrade.student.id
        gradeDto.subjectId = findGrade.subject.id

        return gradeDto
    }

}