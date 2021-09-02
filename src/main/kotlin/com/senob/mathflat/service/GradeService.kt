package com.senob.mathflat.service

import com.senob.mathflat.domain.Grade
import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.repository.SubjectRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class GradeService(val gradeRepository: GradeRepository, val studentRepository: StudentRepository, val subjectRepository: SubjectRepository){
    fun addGrade(subjectId: Long, studentId: Long, gradeDto: GradeDto): GradeDto {
        val findStudent = studentRepository.findById(studentId).orElseThrow { EntityNotFoundException("studentId = '${studentId}', 학생 정보를 찾을 수 없습니다.") }
        val findSubject = subjectRepository.findById(subjectId).orElseThrow { EntityNotFoundException("subjectId = '${subjectId}', 과목을 찾을 수 없습니다.") }
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
        val findGrade = gradeRepository.findById(id).orElseThrow { EntityNotFoundException("gradeId = '${id}', 점수 정보를 찾을 수 없습니다.") }

        // 과목 점수 수정
        findGrade.score = gradeDto.score
        gradeRepository.save(findGrade)

        gradeDto.id = findGrade.id
        gradeDto.studentId = findGrade.student.id
        gradeDto.subjectId = findGrade.subject.id

        return gradeDto
    }

}