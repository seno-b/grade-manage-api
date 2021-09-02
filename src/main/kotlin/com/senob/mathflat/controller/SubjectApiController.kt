package com.senob.mathflat.controller

import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.dto.SubjectDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.SubjectRepository
import com.senob.mathflat.service.GradeService
import com.senob.mathflat.service.SubjectService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min

// 과목 Api Controller
@RestController
@RequestMapping("/subject")
@Validated
class SubjectApiController(val subjectRepository: SubjectRepository, val gradeRepository: GradeRepository, val subjectService: SubjectService, val gradeService: GradeService) {

    // 과목 추가
    @PostMapping
    fun createSubject(@Valid @RequestBody subjectDto: SubjectDto) : ResponseEntity<SubjectDto> = ResponseEntity
        .ok()
        .body(subjectService.putSubject(subjectDto))

    // 과목 삭제
    @DeleteMapping("/{subject-id}")
    fun deleteSubject(@PathVariable("subject-id") @Min(1) id: Long) : ResponseEntity<Unit> = ResponseEntity
        .ok()
        .body(subjectRepository.deleteById(id))

    // 특정 과목 학생 점수 추가
    @PostMapping("/{subject-id}/{student-id}")
    fun addGrade(@PathVariable("subject-id") @Min(1) subjectId: Long, @PathVariable("student-id") @Min(1) studentId: Long, @Valid @RequestBody gradeDto: GradeDto): ResponseEntity<GradeDto> = ResponseEntity
        .ok()
        .body(gradeService.addGrade(subjectId, studentId, gradeDto))

    // 특정 과목의 전체 학생 평균 점수 조회
    @GetMapping("/{subject-id}/grade-avg")
    fun searchSubjectAvgGrades(@PathVariable("subject-id") @Min(1) subjectId: Long) : ResponseEntity<Long> = ResponseEntity
        .ok()
        .body(gradeRepository.findGradeAvgBySubjectId(subjectId))
}