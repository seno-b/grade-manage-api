package com.senob.mathflat.controller

import com.senob.mathflat.dto.GradeDto
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.service.GradeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/grade")
class GradeApiController(val gradeRepository: GradeRepository, val gradeService: GradeService){

    // 특정 과목 학생 점수 수정
    @PutMapping("/{grade-id}")
    fun updateGrade(@PathVariable("grade-id") id: Long, @RequestBody gradeDto: GradeDto) : GradeDto {

        var resultDto: GradeDto = gradeService.updateGrade(id, gradeDto)

        return resultDto
    }

    // 특정 과목 학생 점수를 삭제
    @DeleteMapping("/{grade-id}")
    fun deleteGrade(@PathVariable("grade-id") id: Long){
        gradeRepository.deleteById(id)
    }
}