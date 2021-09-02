package com.senob.mathflat.controller

import com.senob.mathflat.dto.StudentDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min

// 학생 Api Controller
@RestController
@RequestMapping("/student")
@Validated
class StudentApiController(val studentRepository: StudentRepository, val gradeRepository: GradeRepository, val studentService: StudentService) {

    // 학생 추가
    @PostMapping
    fun createStudent(@Valid @RequestBody studentDto: StudentDto): ResponseEntity<StudentDto> = ResponseEntity
        .ok()
        .body(studentService.putStudent(studentDto))

    // 학생 삭제
    @DeleteMapping("/{student-id}")
    fun deleteStudent(@PathVariable("student-id") @Min(1) id: Long): ResponseEntity<Unit> = ResponseEntity
        .ok()
        .body(studentRepository.deleteById(id))

    // 특정 학생의 평균 점수 조회
    @GetMapping("/{student-id}/{classroom-id}/grade-avg")
    fun searchStudentAvgGrades(@PathVariable("student-id") @Min(1) studentId: Long, @PathVariable("classroom-id") @Min(1) classRoomId: Long): ResponseEntity<Long> = ResponseEntity
        .ok()
        .body(gradeRepository.findGradeAvgByStudentIdAndClassroomId(studentId, classRoomId))
}