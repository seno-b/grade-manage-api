package com.senob.mathflat.service

import com.senob.mathflat.domain.Student
import com.senob.mathflat.domain.Subject
import com.senob.mathflat.dto.StudentDto
import com.senob.mathflat.dto.SubjectDto
import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class StudentService(val studentRepository: StudentRepository, val classRoomRepository: ClassRoomRepository, val subjectRepository: SubjectRepository){

    fun putSubject(subjectDto: SubjectDto): SubjectDto {
        // 강의 조회
        val findClassRoom = classRoomRepository.findById(subjectDto.classId).get()

        // 과목 생성
        val subject = Subject(subjectDto.name)
        subject.classRoom = findClassRoom
        subjectRepository.save(subject)
        subjectDto.id = subject.id

        return subjectDto
    }

    fun putStudent(studentDto: StudentDto): StudentDto {
        val student = Student(studentDto.name, studentDto.grade, studentDto.schoolName)
        studentRepository.save(student)
        studentDto.id = student.id

        return studentDto
    }
}