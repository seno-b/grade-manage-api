package com.senob.mathflat.controller

import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.service.GradeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min

@RestController
@RequestMapping("/grade")
@Validated
class GradeApiController(val gradeRepository: GradeRepository, val gradeService: GradeService){

    // 특정 과목 학생 점수 수정
    @PutMapping("/{grade-id}")
    fun updateGrade(@PathVariable("grade-id") @Min(1) id: Long, @Valid @RequestBody gradeDto: GradeDto): ResponseEntity<GradeDto> = ResponseEntity
        .ok()
        .body(gradeService.updateGrade(id, gradeDto))

    // 특정 과목 학생 점수를 삭제
    @DeleteMapping("/{grade-id}")
    fun deleteGrade(@PathVariable("grade-id") @Min(1) id: Long): ResponseEntity<Unit> = ResponseEntity
        .ok()
        .body(gradeRepository.deleteById(id))
}