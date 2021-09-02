package com.senob.mathflat.controller

import com.senob.mathflat.domain.Student
import com.senob.mathflat.dto.StudentDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.service.StudentService
import org.springframework.web.bind.annotation.*

// 학생 Api Controller
@RestController
@RequestMapping("/student")
class StudentApiController(val studentRepository: StudentRepository, val gradeRepository: GradeRepository, val studentService: StudentService) {

    // 학생 추가
    @PostMapping
    fun createStudent(@RequestBody studentDto: StudentDto): StudentDto {

        var resultDto: StudentDto = studentService.putStudent(studentDto)

        return resultDto
    }

    // 학생 삭제
    @DeleteMapping("/{student-id}")
    fun deleteStudent(@PathVariable("student-id") id: Long){
        studentRepository.deleteById(id)
    }

    // 특정 학생의 평균 점수 조회
    @GetMapping("/{student-id}/{classroom-id}/grade-avg")
    fun searchStudentAvgGrades(@PathVariable("student-id") studentId: Long, @PathVariable("classroom-id") classRoomId: Long) : Long? {
        return gradeRepository.findGradeAvgByStudentIdAndClassroomId(studentId, classRoomId)
    }
}