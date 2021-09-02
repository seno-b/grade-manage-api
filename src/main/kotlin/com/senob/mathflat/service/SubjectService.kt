package com.senob.mathflat.service

import com.senob.mathflat.domain.Subject
import com.senob.mathflat.dto.SubjectDto
import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.SubjectRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class SubjectService(val classRoomRepository: ClassRoomRepository, val subjectRepository: SubjectRepository){

    fun putSubject(subjectDto: SubjectDto): SubjectDto {
        // 강의 조회
        val findClassRoom = classRoomRepository.findById(subjectDto.classId).orElseThrow { EntityNotFoundException("classId = '${subjectDto.classId}', 강의를 찾을 수 없습니다.") }

        // 과목 생성
        val subject = Subject(subjectDto.name)
        subject.classRoom = findClassRoom
        subjectRepository.save(subject)
        subjectDto.id = subject.id

        return subjectDto
    }
}