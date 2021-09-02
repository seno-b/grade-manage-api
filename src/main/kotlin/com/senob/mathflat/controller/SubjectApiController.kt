package com.senob.mathflat.controller

import com.senob.mathflat.service.StudentService
import com.senob.mathflat.domain.Grade
import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.dto.SubjectDto
import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.repository.SubjectRepository
import com.senob.mathflat.service.GradeService
import com.senob.mathflat.service.SubjectService
import org.springframework.web.bind.annotation.*

// 과목 Api Controller
@RestController
@RequestMapping("/subject")
class SubjectApiController(val subjectRepository: SubjectRepository, val gradeRepository: GradeRepository, val subjectService: SubjectService, val gradeService: GradeService
) {

    // 과목 추가
    @PostMapping
    fun createSubject(@RequestBody subjectDto: SubjectDto) : SubjectDto {

        val resultDto:SubjectDto = subjectService.putSubject(subjectDto)

        return resultDto
    }

    // 과목 삭제
    @DeleteMapping("/{subject-id}")
    fun deleteSubject(@PathVariable("subject-id") id: Long){
        subjectRepository.deleteById(id)
    }

    // 특정 과목 학생 점수 추가
    @PostMapping("/{subject-id}/{student-id}")
    fun addGrade(@PathVariable("subject-id") subjectId: Long, @PathVariable("student-id") studentId: Long, @RequestBody gradeDto: GradeDto) : GradeDto {

        var resultDto: GradeDto = gradeService.addGrade(subjectId, studentId, gradeDto)

        return resultDto
    }

    // 특정 과목의 전체 학생 평균 점수 조회
    @GetMapping("/{subject-id}/grade-avg")
    fun searchSubjectAvgGrades(@PathVariable("subject-id") subjectId: Long) : Long{
        return gradeRepository.findGradeAvgBySubjectId(subjectId)
    }
}